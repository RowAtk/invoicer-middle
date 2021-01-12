package com.rowatk.invoicer.dto.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter @Setter @ToString
public class ItemDTO {

    private Long item_id;

    private Long invoice_num;

    private String description;

    private double quantity;

    private double unit_price;

    @JsonGetter
    public BigDecimal getTotal() {
        return BigDecimal.valueOf(this.quantity * this.unit_price);
    }
}
