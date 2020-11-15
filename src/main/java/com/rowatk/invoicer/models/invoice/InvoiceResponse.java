package com.rowatk.invoicer.models.invoice;

import com.rowatk.invoicer.models.entity.Buyer;
import com.rowatk.invoicer.models.entity.Seller;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class InvoiceResponse {

    private int invoice_num;
    private String header;
    private Date issue_date;
    private Date due_date;
    private Date delivery_date;
    private Seller seller;
    private Buyer buyer;
    private String note;
    private boolean paid = false;
    private  Status status;

    public int getInvoice_num() {
        return invoice_num;
    }

    public void setInvoice_num(int invoice_num) {
        this.invoice_num = invoice_num;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public Seller getSellerId() {
        return seller;
    }

    public void setSellerId(Seller seller) {
        this.seller = seller;
    }

    public Buyer getBuyerId() {
        return buyer;
    }

    public void setBuyerId(Buyer buyer) {
        this.buyer = buyer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoice_num='" + invoice_num + '\'' +
                ", header='" + header + '\'' +
                ", issue_date=" + issue_date +
                ", due_date=" + due_date +
                ", delivery_date=" + delivery_date +
                ", seller=" + seller +
                ", buyer=" + buyer +
                ", note='" + note + '\'' +
                '}';
    }
}



