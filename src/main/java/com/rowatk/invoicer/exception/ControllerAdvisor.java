package com.rowatk.invoicer.exception;

import com.rowatk.invoicer.dto.responses.ApiResponse;
import com.rowatk.invoicer.dto.responses.ApiResponseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAdvisor.class);

    @ExceptionHandler(NoRecordException.class)
    public ResponseEntity<ApiResponse> handleNoRecordException(NoRecordException ex, WebRequest request) {

        System.out.println(request);
        String message = String.format("No %s found with the %s: %s", ex.getType(), ex.getIdType(), ex.getIdValue());
        logger.error(message);
        return ApiResponseFactory.notFound(message);
    }
}
