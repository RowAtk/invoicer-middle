package com.rowatk.invoicer.models.common;

import java.util.ArrayList;
import java.util.List;

public class SimpleResponse {

    private int status;
    private String message;
    private List<String> errorMessages = new ArrayList<>();

    public SimpleResponse() {
    }

    public SimpleResponse(String message) {
        this.message = message;
    }

    public SimpleResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public SimpleResponse(int status, String message, List<String> errorMessages) {
        this.status = status;
        this.message = message;
        this.errorMessages = errorMessages;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
