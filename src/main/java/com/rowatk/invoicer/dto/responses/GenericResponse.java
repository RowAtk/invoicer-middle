package com.rowatk.invoicer.dto.responses;

import com.rowatk.invoicer.dto.DTO;

public class GenericResponse implements DTO {

    private Object result;
    private final String key;

    public GenericResponse(Object result, String key) {
        this.result = result;
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
