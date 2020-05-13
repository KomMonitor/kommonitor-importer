package org.n52.kommonitor.importer.api;

import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.n52.kommonitor.importer.api.handler.ApiExceptionHandler;
import org.n52.kommonitor.importer.io.file.FileStorageService;
import org.n52.kommonitor.importer.utils.ImportMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(UploadApiController.class)
@ContextConfiguration(classes = {UploadApiController.class, ApiExceptionHandler.class})
public class UploadApiControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FileStorageService storageService;

    @MockBean
    private ImportMonitor monitor;

    @Test
    @DisplayName("Test upload responds with 201 status code for successful upload")
    void testUpload() throws Exception {
        String fileName = "test.xml";
        MockMultipartFile multipartFile = new MockMultipartFile("file", fileName,
                "text/plain", "test content".getBytes());
        Mockito.when(storageService.store(Mockito.any(MultipartFile.class), Mockito.anyString())).thenReturn(fileName);

        this.mockMvc.perform(MockMvcRequestBuilders.multipart("/upload")
                .file(multipartFile).param("filename", fileName))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").value(fileName));
    }

    @Test
    @DisplayName("Test get uploaded files responds with 200 status code")
    void testGetUploadedFiles() throws Exception {
        String fileName = "test.xml";
        File file = Mockito.mock(File.class);
        Mockito.when(file.getName()).thenReturn(fileName);

        Mockito.when(storageService.getAll()).thenReturn(Collections.singletonList(file));

        this.mockMvc.perform(get("/upload"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$[0].name").value(fileName));
    }

    @Test
    @DisplayName("Test upload responds with 500 status code for UploadException")
    void testUploadShouldThrowIOExceptionForStorageFailure() throws Exception {
        String fileName = "test.xml";
        MockMultipartFile multipartFile = new MockMultipartFile("file", fileName,
                "text/plain", "test content".getBytes());
        Mockito.when(storageService.store(Mockito.any(MultipartFile.class), Mockito.anyString())).thenThrow(IOException.class);

        this.mockMvc.perform(MockMvcRequestBuilders.multipart("/upload")
                .file(multipartFile).param("filename", fileName))
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }


}
