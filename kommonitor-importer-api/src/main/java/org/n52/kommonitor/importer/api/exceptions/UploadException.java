package org.n52.kommonitor.importer.api.exceptions;

import org.springframework.web.multipart.MultipartFile;

/**
 * Indicates that there was a failure when uploading and storing a file
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class UploadException extends Exception {

    private MultipartFile file;

    public UploadException(MultipartFile file) {
        super(String.format("Upload failure for file '%s'.", file.getName()));
        this.file = file;
    }

    public UploadException(MultipartFile file, Throwable cause) {
        super(String.format("Upload failure for file '%s'.", file.getName()), cause);
        this.file = file;
    }
}
