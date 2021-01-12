package com.rowatk.invoicer.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rowatk.invoicer.dto.model.InvoiceDTO;
import com.rowatk.invoicer.dto.model.ItemDTO;

import java.util.List;

public class CreateInvoiceRequest {

    @JsonProperty("invoice")
    private InvoiceDTO invoice;

    @JsonProperty("items")
    private List<ItemDTO> items;

    public InvoiceDTO getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDTO invoice) {
        this.invoice = invoice;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CreateInvoiceRequest{" +
                "invoice=" + invoice +
                ", items=" + items +
                '}';
    }
}
