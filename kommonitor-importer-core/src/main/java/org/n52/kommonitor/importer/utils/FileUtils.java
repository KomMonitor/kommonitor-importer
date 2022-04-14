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
	
	private static Logger logger = LoggerFactory.getLogger(FileUtils.class);
	
	public static boolean isFileEncodingUtf8(File inputFile) throws IOException {
        return isUtf8(getFileEncoding(inputFile));
    }

    public static String getFileEncoding(File file) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file);) {
            return getInputStreamEncoding(fileInputStream);
        }
    }

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

    public static File convertFileToUtf8(File inputFile, File outputFile) throws IOException {
    	logger.warn("detecting inputFile encoding and convert it to UTF-8 if neccessary.");
        final String encoding = getFileEncoding(inputFile);
        if (StringUtils.isEmpty(encoding)) {
        	logger.warn("inputFile encoding can not parsed!");
        	return inputFile;
//            throw new RuntimeException("inputFile encoding can not parsed!");
        }
        if (isUtf8(encoding)) {
        	logger.warn("inputFile is already utf8, no need convert.");
        	return inputFile;
//            throw new RuntimeException("inputFile is already utf8, no need convert.");
        }

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
