package org.n52.kommonitor.importer.api.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.n52.kommonitor.importer.api.exceptions.ImportException;
import org.n52.kommonitor.importer.api.exceptions.ResourceNotFoundException;
import org.n52.kommonitor.importer.api.exceptions.UploadException;
import org.n52.kommonitor.importer.api.utils.ErrorFactory;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.utils.ImportMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@ControllerAdvice
public class ApiExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @Autowired
    private ImportMonitor monitor;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {

        String fieldErrorMessage = "";
        String globalErrorMessage = "";
        if (ex.getBindingResult().getFieldErrorCount() > 0) {
            Map<String, String> errorMessages = new HashMap<>();
            ex.getBindingResult().getFieldErrors().forEach(e -> errorMessages.put(e.getField(), e.getDefaultMessage()));
            fieldErrorMessage = String.format("Invalid request content:%n%s", errorMessages);
        }
        if (ex.getBindingResult().getGlobalErrorCount() > 0) {
            List<String> errorMessages = new ArrayList<>();
            ex.getBindingResult().getGlobalErrors().forEach(e -> errorMessages.add(e.getDefaultMessage()));
            globalErrorMessage = String.format("Unexpected error(s):%n%s", errorMessages);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorFactory.getError(HttpStatus.BAD_REQUEST.value(),
                        String.format("%s%n%s", fieldErrorMessage, globalErrorMessage)));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableExceptions(HttpMessageNotReadableException ex) {
        LOG.error("Failed reading HTTP message: {}", ex.getMessage());
        LOG.debug("Failed reading HTTP message", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorFactory.getError(HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundExceptions(ResourceNotFoundException ex) {
        LOG.error("No '{}' resource available with requested id '{}' ", ex.getResource().getName(), ex.getType());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorFactory.getError(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    @ExceptionHandler(ImportParameterException.class)
    public ResponseEntity<?> handleImportParameterExceptions(ImportParameterException ex) {
        LOG.error("Invalid request parameters: {}", ex.getMessage());
        LOG.debug("Invalid request parameters", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorFactory.getError(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler({ImportException.class, UploadException.class})
    public ResponseEntity<?> handleImportExceptions(Exception ex) {
        LOG.error("Error while handling import request: {}", ex.getMessage());
        LOG.debug("Error while handling import request", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorFactory.getError(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        ex.getMessage(),
                        monitor.getErrorMessages()));
    }

    @ExceptionHandler({RestClientException.class})
    public ResponseEntity<?> handleKomMonitorManagementError(Exception ex) {
        LOG.error("Data Management API client error: {}", ex.getMessage());
        LOG.debug("Data Management API client error", ex);

        if (ex instanceof HttpServerErrorException serverError) {
            String responseBodyAsString = serverError.getResponseBodyAsString();

            String errorMessageFromManagementApi = "Error in KomMonitor Data Management API: ";

            ObjectMapper mapper = new ObjectMapper();
            try {
                JsonNode responseBodyAsJson = mapper.readTree(responseBodyAsString);

                String labelValue = responseBodyAsJson.findValue("label").asText();
                String messageValue = responseBodyAsJson.findValue("message").asText();

                if (labelValue != null && messageValue != null) {
                    errorMessageFromManagementApi = errorMessageFromManagementApi + labelValue + "; " + messageValue;
                }

            } catch (JsonProcessingException e) {
                errorMessageFromManagementApi += responseBodyAsString;
            }

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorFactory.getError(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessageFromManagementApi));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorFactory.getError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
        }
    }

}
