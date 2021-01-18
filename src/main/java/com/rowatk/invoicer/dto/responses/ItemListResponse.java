package com.rowatk.invoicer.dto.responses;

import com.rowatk.invoicer.dto.DTO;
import com.rowatk.invoicer.dto.model.ItemDTO;

import java.math.BigDecimal;
import java.util.List;

public class ItemListResponse implements DTO {

    private List<ItemDTO> items;

    public ItemListResponse() {
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public BigDecimal getInvoice_total() {
        return items.stream().map(ItemDTO::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String getKey() {
        return null;
    }
}
