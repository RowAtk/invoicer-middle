package com.rowatk.invoicer.models.invoice;

import com.rowatk.invoicer.models.buyer.Buyer;
import com.rowatk.invoicer.models.seller.Seller;

import java.util.Date;

public class Invoice {

    private String invoice_num;
    private String header;
    private Date issue_date;
    private Date due_date;
    private Date delivery_date;
    private Seller seller;
    private Buyer buyer;
    private String note;

    public Invoice() {}

//    public Invoice(
//            String invoice_num,
//            String header,
//            Date issue_date,
//            Date due_date,
//            Date delivery_date,
//            Seller seller,
//            Buyer buyer,
//            String note) {
//        this.invoice_num = invoice_num;
//        this.header = header;
//        this.issue_date = issue_date;
//        this.due_date = due_date;
//        this.delivery_date = delivery_date;
//        this.seller = seller;
//        this.buyer = buyer;
//        this.note = note;
//    }


    public Invoice(String invoice_num, String header, Date issue_date, Date due_date, Date delivery_date, Seller seller, Buyer buyer, String note) {
        this.invoice_num = invoice_num;
        this.header = header;
        this.issue_date = issue_date;
        this.due_date = due_date;
        this.delivery_date = delivery_date;
        this.seller = seller;
        this.buyer = buyer;
        this.note = note;
    }

    public String getInvoice_num() {
        return invoice_num;
    }

    public void setInvoice_num(String invoice_num) {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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



