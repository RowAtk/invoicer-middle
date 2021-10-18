package com.rowatk.invoicer.dto.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.rowatk.invoicer.dto.DTO;

import java.math.BigDecimal;


public class ItemDTO implements DTO {

    private Long itemId;

    private Long invoiceNum;

    private String description;

    private double quantity;

    private double unitPrice;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(Long invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @JsonGetter
    public BigDecimal getTotal() {
        return BigDecimal.valueOf(this.quantity * this.unitPrice);
    }

    @Override
    public String getKey() {
        return "item";
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId=" + itemId +
                ", invoiceNum=" + invoiceNum +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
