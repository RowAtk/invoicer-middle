package com.rowatk.invoicer.dto.responses;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.rowatk.invoicer.dto.DTO;
import com.rowatk.invoicer.dto.model.EntityDTO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ListResponse implements DTO {

    private List<DTO> list;
    private final String key;

    public ListResponse(List<DTO> list, String key) {
        this.list = list;
        this.key = key;
    }

    public List<DTO> getList() {
        return list;
    }

    public void setList(List<DTO> list) {
        this.list = list;
    }

    @Override
    public String getKey() {
        return key;
    }
}
