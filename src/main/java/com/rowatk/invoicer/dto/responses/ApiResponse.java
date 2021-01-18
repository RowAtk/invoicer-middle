package com.rowatk.invoicer.dto.responses;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.rowatk.invoicer.dto.DTO;
import org.springframework.http.HttpStatus;

import java.util.*;

public class ApiResponse {

    private String status;
    private int code;
    private List<String> messages = Collections.emptyList();
    private DTO result = null;

    public ApiResponse(String status, int code, List<String> messages, DTO result) {
        this.status = status;
        this.code = code;
        this.messages = messages;
        this.result = result;
    }

    public ApiResponse(String status, int code, List<String> messages) {
        this.status = status;
        this.code = code;
        this.messages = messages;
    }

    public ApiResponse(String status, int code, String message, DTO result) {
        this.status = status;
        this.code = code;
        this.messages = Collections.singletonList(message);
        this.result = result;
    }


    public ApiResponse(String status, int code, String message) {
        this.status = status;
        this.code = code;
        this.messages = Collections.singletonList(message);
    }

    public ApiResponse(String status, int code, DTO result) {
        this.status = status;
        this.code = code;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @JsonGetter
    public Object getResult() {
        if(result != null) {
            if(!result.getKey().isBlank()) {
                Map<String, DTO> hashMap = new LinkedHashMap<>();
                hashMap.put(result.getKey(), result);
                return hashMap;
            }
        }
        return result;
    }

    public void setResult(DTO result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "status='" + status + '\'' +
                ", code=" + code +
                ", messages=" + messages +
                ", result=" + result +
                '}';
    }
}
