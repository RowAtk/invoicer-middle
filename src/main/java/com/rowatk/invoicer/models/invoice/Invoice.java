package com.rowatk.invoicer.models.invoice;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "invoices")
public class Invoice extends InvoiceBase {

    @JsonProperty("sellerId")
    private int sellerId;

    @JsonProperty("buyerId")
    private int buyerId;

    public Invoice() {}

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "sellerId=" + sellerId +
                ", buyerId=" + buyerId +
                ", dateFormat=" + dateFormat +
                ", invoice_num='" + invoice_num + '\'' +
                ", header='" + header + '\'' +
                ", issue_date=" + issue_date +
                ", due_date=" + due_date +
                ", delivery_date=" + delivery_date +
                ", sellerId=" + sellerId +
                ", buyerId=" + buyerId +
                ", note='" + note + '\'' +
                ", paid=" + paid +
                ", status=" + status +
                '}';
    }
}



