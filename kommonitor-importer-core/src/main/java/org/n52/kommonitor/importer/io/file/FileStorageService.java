package org.n52.kommonitor.importer.io.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * Provides methods for managing files that may be uploaded and should be stored on the server
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties("kommonitor.importer")
public class FileStorageService implements InitializingBean {

    private static final Logger LOG = LoggerFactory.getLogger(FileStorageService.class);

    private String fileStorageLocation;

    private Path basePath;

    private static boolean fileStorageLocationExists;

    public String getFileStorageLocation() {
        return fileStorageLocation;
    }

    public void setFileStorageLocation(String fileStorageLocation) {
        this.fileStorageLocation = fileStorageLocation;
    }

    /**
     * Stores a file from a {@link MultipartFile} at the configured base directory
     *
     * @param file     {@link MultipartFile} to store
     * @param fileName name that will be used to store the
     * @throws IOException
     */
    public void store(@NotNull MultipartFile file, @Nullable String fileName) throws IOException {
        if (fileName != null) {
            FileUtils.writeByteArrayToFile(
                    new File(FilenameUtils.concat(basePath.toString(), fileName)),
                    file.getBytes()
            );
        } else {
            FileUtils.writeByteArrayToFile(
                    new File(FilenameUtils.concat(basePath.toString(), file.getOriginalFilename())),
                    file.getBytes()
            );
        }

    }

    /**
     * Retrieve a {@link File} from the file storage by a certain name
     *
     * @param fileName name of the file that should be retrieved
     * @return the requested {@link File}
     */
    public File get(String fileName) {
        return FileUtils.getFile(basePath.toFile(), fileName);
    }

    /**
     * Retrieve all files from the file storage
     *
     * @return {@link Collection<File>} for all files from the file storage
     */
    public Collection<File> getAll() {
        return FileUtils.listFiles(basePath.toFile(), null, false);
    }

    /**
     * Deletes a {@link File} from the file storage by its name
     *
     * @param fileName the name of the file to delete
     * @throws IOException if the given file could not be deleted
     */
    public void delete(String fileName) throws IOException {
        FileUtils.forceDelete(get(fileName));
    }

    /**
     * Clears the whole file storage
     *
     * @throws IOException if cleaning was not succesfull
     */
    public void clearStorage() throws IOException {
        FileUtils.forceDelete(basePath.toFile());
    }

    @Override
    public void afterPropertiesSet() throws Error {
        basePath = Paths.get(fileStorageLocation);
        fileStorageLocationExists = Files.exists(basePath);
        if (!fileStorageLocationExists) {
            fileStorageLocationExists = new File(fileStorageLocation).mkdirs();
            if (!fileStorageLocationExists) {
                LOG.warn(String.format("The file storage location '%s' does not exist. No files can be uploaded.", fileStorageLocation));
            }
        }

    }
}
