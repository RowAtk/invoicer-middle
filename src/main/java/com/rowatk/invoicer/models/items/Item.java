package com.rowatk.invoicer.models.items;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @SequenceGenerator(
            name = "item_seq",
            sequenceName = "item_seq",
            allocationSize = 1
    )
    private int item_id;

    private String invoice_num;

    @NotBlank
    private String description;

    @NotNull
    private double quantity;

    @NotNull
    private double unit_price;

    public Item() {}

    public Item(@JsonProperty("description") String description, @JsonProperty("quantity") double quantity, @JsonProperty("unit_price") double unit_price) {
        this.description = description;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
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

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double calculateAmount() {
        return this.unit_price * this.quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", unit_price=" + unit_price +
                '}';
    }
}
