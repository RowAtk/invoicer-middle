package com.rowatk.invoicer.dto.responses;

import com.rowatk.invoicer.dto.model.ItemDTO;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
public class ItemListResponse {

    private List<ItemDTO> items;

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public BigDecimal getInvoice_total() {
        return items.stream().map(ItemDTO::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
