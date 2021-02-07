package com.rowatk.invoicer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface DTO {

    @JsonIgnore
    public String getKey();
}
