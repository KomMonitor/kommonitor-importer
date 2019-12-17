package org.n52.kommonitor.importer.api.handler;

import org.n52.kommonitor.importer.api.exceptions.ImportException;
import org.n52.kommonitor.importer.api.exceptions.ResourceNotFoundException;
import org.n52.kommonitor.importer.api.utils.ErrorFactory;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@ControllerAdvice
public class ImportExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ImportExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationExceptions(MethodArgumentNotValidException ex) {

        String fieldErrorMessage = "";
        String globalErrorMessage = "";
        if (ex.getBindingResult().getFieldErrorCount() > 0) {
            Map errorMessages = new HashMap<>();
            ex.getBindingResult().getFieldErrors().forEach(e -> {
                errorMessages.put(e.getField(), e.getDefaultMessage());
            });
            fieldErrorMessage = String.format("Invalid request content:%n%s", errorMessages);
        }
        if (ex.getBindingResult().getGlobalErrorCount() > 0) {
            List errorMessages = new ArrayList();
            ex.getBindingResult().getGlobalErrors().forEach(e -> {
                errorMessages.add(e.getDefaultMessage());
            });
            globalErrorMessage = String.format("Unexpected error(s):%n%s", errorMessages);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorFactory.getError(HttpStatus.BAD_REQUEST.value(),
                        String.format("%s%n%s", fieldErrorMessage, globalErrorMessage)));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFoundExceptions(ResourceNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorFactory.getError(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    @ExceptionHandler(ImportParameterException.class)
    public ResponseEntity handleImportParameterExceptions(ImportParameterException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorFactory.getError(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(ImportException.class)
    public ResponseEntity handleImportExceptions(ImportException ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorFactory.getError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }

}
