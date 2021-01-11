package com.rowatk.invoicer.models.items;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "items")
@IdClass(Item.ItemPK.class)
public class Item {

    @Id
    private Long item_id;

    @Id
    private Long invoice_num;

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

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Long getInvoice_num() {
        return invoice_num;
    }

    public void setInvoice_num(Long invoice_num) {
        this.invoice_num = invoice_num;
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

    static class ItemPK implements Serializable {

        protected Long item_id;
        protected Long invoice_num;

        public ItemPK(){}

        public ItemPK(Long item_id, Long invoice_num) {
            this.item_id = item_id;
            this.invoice_num = invoice_num;
        }

        public Long getItem_id() {
            return item_id;
        }

        public void setItem_id(Long item_id) {
            this.item_id = item_id;
        }

        public Long getInvoice_num() {
            return invoice_num;
        }

        public void setInvoice_num(Long invoice_num) {
            this.invoice_num = invoice_num;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ItemPK itemPK = (ItemPK) o;
            return item_id.equals(itemPK.item_id) && invoice_num.equals(itemPK.invoice_num);
        }

        @Override
        public int hashCode() {
            return Objects.hash(item_id, invoice_num);
        }
    }
}


