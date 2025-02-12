package com.testcontainers.demo.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestControllerAdvice
@NoArgsConstructor
@Log4j2
public class CustomExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Error resourceNotFoundException(final ResourceNotFoundException ex, final WebRequest request) {
        log.error(ex.getMessage());
        final HttpServletRequest servletRequest = ((ServletWebRequest) request).getRequest();
        return new Error(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(),
                request.getDescription(false));
    }

    @ExceptionHandler(TechnicalException.class)
    @ResponseStatus(value = HttpStatus.NOT_EXTENDED)
    public Error technicalExceptionHandler(final TechnicalException ex, final WebRequest request) {
        log.error(ex.getMessage());
        final HttpServletRequest servletRequest = ((ServletWebRequest) request).getRequest();
        return new Error(HttpStatus.NOT_EXTENDED.value(), new Date(), ex.getMessage(),
                request.getDescription(false));
    }

    @ExceptionHandler({FunctionalException.class, ConstraintViolationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Error functionalExceptionHandler(final Exception ex, final WebRequest request) {
        log.error(ex.getMessage());
        final HttpServletRequest servletRequest = ((ServletWebRequest) request).getRequest();
        return new Error(HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage(),
                request.getDescription(false));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(final MethodArgumentNotValidException ex, final WebRequest request) {
        final List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(t -> t.getField() + " : " + t.getDefaultMessage()).collect(Collectors.toList());
        log.error("Error during validation for the following reasons : [ " + String.join(", ", errors) + " ]", request);
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(final List<String> errors) {
        final Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Error globalExceptionHandler(final Exception ex, final WebRequest request) {
        log.error(ex.getMessage());
        final HttpServletRequest servletRequest = ((ServletWebRequest) request).getRequest();
        return new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage(),
                request.getDescription(false));
    }
}