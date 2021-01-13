package com.rowatk.invoicer.dto.model;

import com.rowatk.invoicer.models.entity.Buyer;
import com.rowatk.invoicer.models.entity.Seller;
import com.rowatk.invoicer.models.invoice.InvoiceBase;

public class InvoiceEntityDTO extends InvoiceBase {

    private Seller seller;
    private Buyer buyer;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "InvoiceEntityDTO{" +
                "seller=" + seller +
                ", buyer=" + buyer +
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
