package org.n52.kommonitor.importer.io.file;

import jakarta.validation.constraints.NotNull;
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
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;
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

    public static final String META_MIMETYPE = "meta.mimetype";

    private static final Logger LOG = LoggerFactory.getLogger(FileStorageService.class);

    private String fileStorageLocation;

    private Path basePath;

    private static boolean fileStorageLocationExists;

    public String getFileStorageLocation() {
        return fileStorageLocation;
    }

    public void setFileStorageLocation(String fileStorageLocation) {
        this.fileStorageLocation = fileStorageLocation;
        LOG.info("File storage location: " + fileStorageLocation);
    }

    /**
     * Stores a file from a {@link MultipartFile} at the configured base directory
     *
     * @param multipartFile {@link MultipartFile} to store
     * @param fileName      name that will be used to store the
     * @return name of the stored {@link File}
     * @throws IOException
     */
    public String store(@NotNull MultipartFile multipartFile, @Nullable String fileName) throws IOException {
        String name = fileName != null ? fileName : multipartFile.getOriginalFilename();
        File file = new File(FilenameUtils.concat(basePath.toString(), name));
        FileUtils.writeByteArrayToFile(
                new File(FilenameUtils.concat(basePath.toString(), name)),
                multipartFile.getBytes()
        );

        UserDefinedFileAttributeView view = Files.getFileAttributeView(file.toPath(), UserDefinedFileAttributeView.class);
        if (multipartFile.getContentType() != null) {
            view.write(META_MIMETYPE, ByteBuffer.wrap(multipartFile.getContentType().getBytes()));
        }
        return name;
    }

    /**
     * Gets the metadata from a file that are stored as {@link UserDefinedFileAttributeView}
     *
     * @param metaName the name of the metadata
     * @param file     {@link File} to get the metadata from
     * @return requested metadata value
     * @throws IOException
     */
    public String getMetadata(String metaName, File file) throws IOException {
        UserDefinedFileAttributeView view = Files.getFileAttributeView(file.toPath(), UserDefinedFileAttributeView.class);
        ByteBuffer buffer = ByteBuffer.allocate(view.size(metaName));
        view.read(metaName, buffer);
        buffer.flip();
        return StandardCharsets.UTF_8.decode(buffer).toString();
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
