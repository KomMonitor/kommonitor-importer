package org.n52.kommonitor.importer.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class FileUtilsTest {

    private static final String CONTENT = "Stadtteil;Straße;Einwohner\n"
            + "Altstadt;Königsstraße;1234\n"
            + "Mitte;Bahnhofstraße;2345\n"
            + "Süd;Grüner Weg;3456\n"
            + "Nord;Übergang am Fluß;4567\n"
            + "Ost;Mühlenstraße;5678\n";

    private static final String UTF_8 = "UTF-8";
    private static final String ISO_8859_1 = "ISO-8859-1";

    @TempDir
    Path tempDir;

    @Test
    @DisplayName("Test get input stream encoding for UTF-8 encoded content")
    void testGetInputStreamEncodingForUtf8Content() throws IOException {
        InputStream input = new ByteArrayInputStream(CONTENT.getBytes(StandardCharsets.UTF_8));

        Assertions.assertEquals(UTF_8, FileUtils.getInputStreamEncoding(input));
    }

    @Test
    @DisplayName("Test get input stream encoding for ISO-8859-1 encoded content")
    void testGetInputStreamEncodingForIso88591Content() throws IOException {
        InputStream input = new ByteArrayInputStream(CONTENT.getBytes(StandardCharsets.ISO_8859_1));

        Assertions.assertEquals(ISO_8859_1, FileUtils.getInputStreamEncoding(input));
    }

    @Test
    @DisplayName("Test get input stream encoding should not consume a buffered input stream")
    void testGetInputStreamEncodingShouldNotConsumeBufferedInputStream() throws IOException {
        byte[] bytes = CONTENT.getBytes(StandardCharsets.UTF_8);
        BufferedInputStream input = new BufferedInputStream(new ByteArrayInputStream(bytes));

        FileUtils.getInputStreamEncoding(input);

        Assertions.assertArrayEquals(bytes, input.readAllBytes());
    }

    @Test
    @DisplayName("Test get file encoding for UTF-8 encoded file")
    void testGetFileEncodingForUtf8File() throws IOException {
        File file = createFile("utf8.csv", StandardCharsets.UTF_8);

        Assertions.assertEquals(UTF_8, FileUtils.getFileEncoding(file));
    }

    @Test
    @DisplayName("Test get file encoding for ISO-8859-1 encoded file")
    void testGetFileEncodingForIso88591File() throws IOException {
        File file = createFile("latin1.csv", StandardCharsets.ISO_8859_1);

        Assertions.assertEquals(ISO_8859_1, FileUtils.getFileEncoding(file));
    }

    @Test
    @DisplayName("Test get file encoding should throw IOException for non existing file")
    void testGetFileEncodingShouldThrowIOExceptionForNonExistingFile() {
        File file = tempDir.resolve("non-existing.csv").toFile();

        Assertions.assertThrows(IOException.class, () -> FileUtils.getFileEncoding(file));
    }

    @Test
    @DisplayName("Test is file encoding UTF-8 for UTF-8 encoded file")
    void testIsFileEncodingUtf8ForUtf8File() throws IOException {
        File file = createFile("utf8.csv", StandardCharsets.UTF_8);

        Assertions.assertTrue(FileUtils.isFileEncodingUtf8(file));
    }

    @Test
    @DisplayName("Test is file encoding UTF-8 for ISO-8859-1 encoded file")
    void testIsFileEncodingUtf8ForIso88591File() throws IOException {
        File file = createFile("latin1.csv", StandardCharsets.ISO_8859_1);

        Assertions.assertFalse(FileUtils.isFileEncodingUtf8(file));
    }

    @Test
    @DisplayName("Test convert file to UTF-8 for ISO-8859-1 encoded file")
    void testConvertFileToUtf8ForIso88591File() throws IOException {
        File inputFile = createFile("latin1.csv", StandardCharsets.ISO_8859_1);
        File outputFile = tempDir.resolve("converted.csv").toFile();

        File result = FileUtils.convertFileToUtf8(inputFile, outputFile);

        Assertions.assertEquals(outputFile, result);
        Assertions.assertEquals(CONTENT, Files.readString(result.toPath(), StandardCharsets.UTF_8));
        Assertions.assertFalse(inputFile.exists());
    }

    @Test
    @DisplayName("Test convert file to UTF-8 should return input file for UTF-8 encoded file")
    void testConvertFileToUtf8ShouldReturnInputFileForUtf8File() throws IOException {
        File inputFile = createFile("utf8.csv", StandardCharsets.UTF_8);
        File outputFile = tempDir.resolve("converted.csv").toFile();

        File result = FileUtils.convertFileToUtf8(inputFile, outputFile);

        Assertions.assertEquals(inputFile, result);
        Assertions.assertEquals(CONTENT, Files.readString(result.toPath(), StandardCharsets.UTF_8));
        Assertions.assertFalse(outputFile.exists());
    }

    @Test
    @DisplayName("Test convert file to UTF-8 with given encoding")
    void testConvertFileToUtf8WithGivenEncoding() throws IOException {
        File inputFile = createFile("latin1.csv", StandardCharsets.ISO_8859_1);
        File outputFile = tempDir.resolve("converted.csv").toFile();

        File result = FileUtils.convertFileToUtf8(inputFile, outputFile, ISO_8859_1);

        Assertions.assertEquals(outputFile, result);
        Assertions.assertTrue(outputFile.exists());
        Assertions.assertEquals(CONTENT, Files.readString(result.toPath(), StandardCharsets.UTF_8));
        Assertions.assertFalse(inputFile.exists());
    }

    @Test
    @DisplayName("Test convert file to UTF-8 with given encoding should overwrite existing output file")
    void testConvertFileToUtf8WithGivenEncodingShouldOverwriteExistingOutputFile() throws IOException {
        File inputFile = createFile("latin1.csv", StandardCharsets.ISO_8859_1);
        File outputFile = tempDir.resolve("converted.csv").toFile();
        Files.writeString(outputFile.toPath(), "previous content", StandardCharsets.UTF_8);

        File result = FileUtils.convertFileToUtf8(inputFile, outputFile, ISO_8859_1);

        Assertions.assertEquals(CONTENT, Files.readString(result.toPath(), StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Test convert file to UTF-8 with given encoding should throw IOException for unsupported encoding")
    void testConvertFileToUtf8WithGivenEncodingShouldThrowIOExceptionForUnsupportedEncoding() throws IOException {
        File inputFile = createFile("latin1.csv", StandardCharsets.ISO_8859_1);
        File outputFile = tempDir.resolve("converted.csv").toFile();

        Assertions.assertThrows(IOException.class,
                () -> FileUtils.convertFileToUtf8(inputFile, outputFile, "NOT-A-CHARSET"));
        Assertions.assertTrue(inputFile.exists());
    }

    private File createFile(String fileName, Charset charset) throws IOException {
        return Files.writeString(tempDir.resolve(fileName), CONTENT, charset).toFile();
    }
}
