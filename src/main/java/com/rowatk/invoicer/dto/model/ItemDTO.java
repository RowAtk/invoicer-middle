package com.rowatk.invoicer.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ItemDTO {

    private Long item_id;

    private Long invoice_num;

    private String description;

    private double quantity;

    private double unit_price;

}
