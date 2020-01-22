package org.n52.kommonitor.importer.io.file;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class FileStorageServiceIT {

    private static final String TMP_DIR_PREFIX = "kommonitor-tmp";

    private static Path tmpDir;
    private static FileStorageService storageService;

    @BeforeAll
    public static void init() throws IOException {
        tmpDir = Files.createTempDirectory(TMP_DIR_PREFIX);
        storageService = new FileStorageService();
        storageService.setFileStorageLocation(tmpDir.toString());
        storageService.afterPropertiesSet();
    }

    @Test
    public void testFileStorageWithFileName() throws IOException {
        MultipartFile file = Mockito.mock(MultipartFile.class);
        Mockito.when(file.getBytes()).thenReturn("test content".getBytes());
        String fileName = "test.txt";

        storageService.store(file, "test.txt");
        File storedFile = storageService.get(fileName);
        Assertions.assertTrue(storedFile.exists());

        String contentTypeMeta = storageService.getMetadata(FileStorageService.META_MIMETYPE, storedFile);
        Assertions.assertEquals("text/xml", contentTypeMeta);
        Assertions.assertThrows(IOException.class, () -> storageService.getMetadata("non-valid-metaName", storedFile));

        storageService.delete(fileName);
        Assertions.assertFalse(storageService.get(fileName).exists());
    }

    @Test
    public void testFileStorageWithoutFileName() throws IOException {
        MultipartFile file = Mockito.mock(MultipartFile.class);
        Mockito.when(file.getBytes()).thenReturn("test content".getBytes());
        String fileName = "test2.txt";
        Mockito.when(file.getOriginalFilename()).thenReturn(fileName);

        storageService.store(file, null);
        Assertions.assertTrue(storageService.get(fileName).exists());

        storageService.clearStorage();
        Assertions.assertFalse(storageService.get(fileName).exists());
    }

    @Test
    public void testGetAllFiles() throws IOException {
        MultipartFile file1 = Mockito.mock(MultipartFile.class);
        Mockito.when(file1.getBytes()).thenReturn("test content".getBytes());
        String fileName1 = "test3.txt";
        Mockito.when(file1.getOriginalFilename()).thenReturn(fileName1);
        storageService.store(file1, null);

        MultipartFile file2 = Mockito.mock(MultipartFile.class);
        Mockito.when(file2.getBytes()).thenReturn("test content".getBytes());
        String fileName2 = "test4.txt";
        Mockito.when(file2.getOriginalFilename()).thenReturn(fileName2);
        storageService.store(file2, null);
    }

    @Test
    public void testDeleteNonExistingFile() {
        Assertions.assertThrows(IOException.class, () -> storageService.delete("non-existing-file.xml"));
    }

    @AfterAll
    public static void shutdown() throws IOException {
        FileUtils.deleteDirectory(tmpDir.toFile());
    }
}
