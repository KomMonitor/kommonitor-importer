package org.n52.kommonitor.importer.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tika.parser.txt.CharsetDetector;
import org.apache.tika.parser.txt.CharsetMatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;

public class FileUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

    /**
     * Checks if encoding of a File is UTF-8
     *
     * @param inputFile Input File to check the encoding for
     * @return True if File encoding is UTF-8
     * @throws IOException if reading of the File or charset detection fails
     */
    public static boolean isFileEncodingUtf8(File inputFile) throws IOException {
        return isUtf8(getFileEncoding(inputFile));
    }

    /***
     * Detects the most likely encoding of a file by using {@link CharsetDetector}
     *
     * @param file File to detect the charset for
     * @return The most likely charset as String
     * @throws IOException if reading of the File or charset detection fails
     */
    public static String getFileEncoding(File file) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            return getInputStreamEncoding(fileInputStream);
        }
    }

    /***
     * Detects the most likely charset of an InputStream by using {@link CharsetDetector}
     *
     * @param input InputStream to detect the charset for
     * @return The most likely charset as String
     * @throws IOException if reading of the InputStream or charset detection fails
     */
    public static String getInputStreamEncoding(InputStream input) throws IOException {
        CharsetDetector charsetDetector = new CharsetDetector();
        BufferedInputStream buffInput = null; // close new BufferedInputStream
        try {
            charsetDetector.setText(
                input instanceof BufferedInputStream ? input : (buffInput = new BufferedInputStream(input)));
            charsetDetector.enableInputFilter(true);
            CharsetMatch cm = charsetDetector.detect();
            return cm.getName();
        } finally {
            IOUtils.closeQuietly(buffInput);
        }
    }

    /***
     * Converts the encoding of a file to UTF-8 if the file is not already encoded in UTF-8. Conversion is done by
     * creating a UTF-8 encoded copy of the file. The encoding of the original file will be guessed by a
     * {@link CharsetDetector}.
     *
     * @param inputFile Input file, which may have a not a UTF-8 encoding
     * @param outputFile Empty output file
     * @return Output file with the same content as the input but in UTF8 encoding
     * @throws IOException if encoding detection or conversion fails
     */
    public static File convertFileToUtf8(File inputFile, File outputFile) throws IOException {
        LOGGER.debug("Detecting input file encoding and convert it to UTF-8 if necessary.");
        final String encoding = getFileEncoding(inputFile);
        LOGGER.debug("Detected '{}' as encoding for dataset.", encoding);
        if (StringUtils.isEmpty(encoding)) {
            LOGGER.warn("inputFile encoding can not parsed!");
        	return inputFile;
        }
        if (isUtf8(encoding)) {
            LOGGER.debug("Input file is already UTF-8, no need convert.");
            return inputFile;
        }
        return convertFileToUtf8(inputFile, outputFile, encoding);
    }

    /***
     * Converts the encoding of a file to UTF-8 if the file is not already encoded in UTF-8. Conversion is done by
     * creating a UTF-8 encoded copy of the file.
     *
     * @param inputFile Input file, which may have a not a UTF-8 encoding
     * @param outputFile Empty output file
     * @param encoding The encoding of the input file
     * @return Output file with the same content as the input but in UTF8 encoding
     * @throws IOException if file creation or conversion of encoding fails
     */
    public static File convertFileToUtf8(File inputFile, File outputFile, String encoding) throws IOException {
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             InputStreamReader inputReader = new InputStreamReader(inputStream, encoding);
             // output
             FileOutputStream outputStream = new FileOutputStream(outputFile);
             OutputStreamWriter outputWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            IOUtils.copy(inputReader, outputWriter);

            // delete inputFile
            inputFile.delete();

            return outputFile;
        }
    }

    private static boolean isUtf8(String encoding) {
        final Set<String> aliases = Sets.newHashSet("utf-8", "utf_8", "utf8");
        for (String utf8 : aliases) {
            if (StringUtils.equalsIgnoreCase(utf8, encoding)) {
                return true;
            }
        }
        return false;
    }

}
