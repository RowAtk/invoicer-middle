package com.rowatk.invoicer.models.items;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "items")
@IdClass(ItemKey.class)
public class Item {

    @Id
    private Long itemId;

    @Id
    private Long invoiceNum;

    @NotBlank
    private String description;

    @NotNull
    private double quantity;

    @NotNull
    private double unitPrice;

    public Item() {}

    public Item(@JsonProperty("description") String description, @JsonProperty("quantity") double quantity, @JsonProperty("unit_price") double unit_price) {
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unit_price;
    }

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

    public double calculateAmount() {
        return this.unitPrice * this.quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", invoiceNum=" + invoiceNum +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}


