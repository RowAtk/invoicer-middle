package com.rowatk.invoicer.dto.model;

import com.rowatk.invoicer.dto.DTO;
import com.rowatk.invoicer.models.invoice.InvoiceBase;

public class InvoiceDTO extends InvoiceBase implements DTO {

    protected Long sellerId = 1L;
    protected Long buyerId;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    @Override
    public String getKey() {
        return "invoice";
    }

    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "sellerId=" + sellerId +
                ", buyerId=" + buyerId +
                ", dateFormat=" + dateFormat +
                ", invoice_num=" + invoiceNum +
                ", issue_date=" + issueDate +
                ", due_date=" + dueDate +
                ", delivery_date=" + deliveryDate +
                ", note='" + note + '\'' +
                ", paid=" + paid +
                ", status=" + status +
                '}';
    }
}
