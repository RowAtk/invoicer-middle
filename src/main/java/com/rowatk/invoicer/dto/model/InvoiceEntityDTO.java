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
        return "InvoiceResponse{" +
                "seller=" + seller +
                ", buyer=" + buyer +
                ", dateFormat=" + dateFormat +
                ", invoice_num='" + invoice_num + '\'' +
                ", issue_date=" + issue_date +
                ", due_date=" + due_date +
                ", delivery_date=" + delivery_date +
                ", note='" + note + '\'' +
                ", paid=" + paid +
                ", status=" + status +
                '}';
    }
}
