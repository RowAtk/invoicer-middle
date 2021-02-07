package com.rowatk.invoicer.dto.responses;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rowatk.invoicer.dto.DTO;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralResponse implements DTO {

    private Map<String, Object> values = new HashMap<>();

    public GeneralResponse() {
    }

    public GeneralResponse(String key, Object value) {
        this.put(key, value);
    }

    @JsonAnySetter
    public void put(String key, Object value) {
        this.values.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "GeneralResponse{" +
                "values=" + values +
                '}';
    }

    @Override
    public String getKey() {
        return null;
    }
}
