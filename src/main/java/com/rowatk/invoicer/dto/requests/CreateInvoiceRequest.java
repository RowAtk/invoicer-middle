package com.rowatk.invoicer.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rowatk.invoicer.dto.model.InvoiceDTO;
import com.rowatk.invoicer.dto.model.ItemDTO;

import java.util.List;

public class CreateInvoiceRequest extends InvoiceDTO {

    @JsonProperty("items")
    private List<ItemDTO> items;

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CreateInvoiceRequest{" +
                "sellerId=" + sellerId +
                ", buyerId=" + buyerId +
                ", items=" + items +
                ", dateFormat=" + dateFormat +
                ", invoiceNum=" + invoiceNum +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", deliveryDate=" + deliveryDate +
                ", note='" + note + '\'' +
                ", paid=" + paid +
                ", status=" + status +
                '}';
    }
}
