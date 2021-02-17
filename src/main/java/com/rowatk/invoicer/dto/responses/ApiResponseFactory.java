package com.rowatk.invoicer.dto.responses;


import com.rowatk.invoicer.dto.DTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

public class ApiResponseFactory {

    // Common
    public static ResponseEntity<ApiResponse> createResponse(String status, int code, List<String> messages, DTO result) {
        return ResponseEntity.status(code).body( new ApiResponse(status, code, messages, result));
    }

    public static ResponseEntity<ApiResponse> createResponse(String status, int code, String message, DTO result) {
        return ResponseEntity.status(code).body( new ApiResponse(status, code, message, result));
    }


    // OK 200
    public static ResponseEntity<ApiResponse> ok(DTO result, List<String> messages) {
        return createResponse("ok", 200, messages, result);
    }

    public static ResponseEntity<ApiResponse> ok(DTO result, String message) {
        return ok(result, Collections.singletonList(message));
    }

    public static ResponseEntity<ApiResponse> ok(DTO result) {
        return ok(result, Collections.emptyList());
    }

    // BAD REQUEST 400
    public static ResponseEntity<ApiResponse> badRequest(DTO result, List<String> messages) {
        return createResponse("error", HttpStatus.BAD_REQUEST.value(), messages, result);
    }

    public static ResponseEntity<ApiResponse> badRequest(DTO result, String message) {
        return badRequest(result, Collections.singletonList(message));
    }

    public static ResponseEntity<ApiResponse> badRequest(DTO result) {
        return badRequest(result, Collections.emptyList());
    }

    // NOT FOUND
    public static ResponseEntity<ApiResponse> notFound(DTO result, List<String> messages) {
        return createResponse("error", HttpStatus.NOT_FOUND.value(), messages, result);
    }

    public static ResponseEntity<ApiResponse> notFound(DTO result, String message) {
        return notFound(result, Collections.singletonList(message));
    }

    public static ResponseEntity<ApiResponse> notFound(String message) {
        return notFound(null, Collections.singletonList(message));
    }


    // SERVER ERROR 500
    public static ResponseEntity<ApiResponse> serverError(DTO result, List<String> messages) {
        return createResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), messages, result);
    }

    public static ResponseEntity<ApiResponse> serverError(DTO result, String message) {
        return serverError(result, Collections.singletonList(message));
    }

    public static ResponseEntity<ApiResponse> serverError(DTO result) {
        return serverError(result, Collections.emptyList());
    }

    public static ResponseEntity<ApiResponse> serverError(String message) {
        return serverError(null, Collections.singletonList(message));
    }


    // UNAUTHORIZED 401
    public static ResponseEntity<ApiResponse> unauthorized(DTO result, List<String> messages) {
        return createResponse("error", HttpStatus.UNAUTHORIZED.value(), messages, result);
    }

    public static ResponseEntity<ApiResponse> unauthorized(DTO result, String message) {
        return unauthorized(result, Collections.singletonList(message));
    }

    public static ResponseEntity<ApiResponse> unauthorized(DTO result) {
        return unauthorized(result, Collections.emptyList());
    }

    public static ResponseEntity<ApiResponse> unauthorized(String message) {
        return unauthorized(null, Collections.singletonList(message));
    }
}
