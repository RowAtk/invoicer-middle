package com.rowatk.invoicer.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rowatk.invoicer.models.invoice.Invoice;
import com.rowatk.invoicer.models.items.Item;

import java.util.Arrays;

public class CreateInvoiceRequest {

    @JsonProperty("invoice")
    private Invoice invoice;

    @JsonProperty("items")
    private Item[] items;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CreateInvoiceRequest{" +
                "invoice=" + invoice +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
