package com.rowatk.invoicer.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rowatk.invoicer.models.invoice.InvoiceBase;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InvoiceDTO extends InvoiceBase {

    private int sellerId;
    private int buyerId;

    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "sellerId=" + sellerId +
                ", buyerId=" + buyerId +
                ", dateFormat=" + dateFormat +
                ", invoice_num=" + invoice_num +
                ", issue_date=" + issue_date +
                ", due_date=" + due_date +
                ", delivery_date=" + delivery_date +
                ", note='" + note + '\'' +
                ", paid=" + paid +
                ", status=" + status +
                '}';
    }
}
