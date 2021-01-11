package com.rowatk.invoicer.models.invoice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@MappedSuperclass
public abstract class InvoiceBase {

    protected final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long invoice_num;

    @JsonProperty("issue_date")
    protected Date issue_date;

    @JsonProperty("due_date")
    protected Date due_date;

    @JsonProperty("delivery_date")
    protected Date delivery_date;

    @JsonProperty("sellerId")
    protected int sellerId;

    @JsonProperty("buyerId")
    protected int buyerId;

    protected String note;
    protected boolean paid = false;
    protected Status status = Status.OPEN;

    public InvoiceBase() {}

    public Long getInvoice_num() {
        return invoice_num;
    }

    public void setInvoice_num(Long invoice_num) {
        this.invoice_num = invoice_num;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    @JsonSetter("issue_date")
    public void setIssue_date(String issue_date) throws ParseException {
        System.out.println("ISSUE DATE: " + issue_date);
        this.setIssue_date(!issue_date.isBlank() ? dateFormat.parse(issue_date) : new Date());
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    @JsonSetter("due_date")
    public void setDue_date(String due_date) throws ParseException {
        this.setDue_date(dateFormat.parse(due_date));
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    @JsonSetter("delivery_date")
    public void setDelivery_date(String delivery_date) throws ParseException {
        this.setDelivery_date(dateFormat.parse(delivery_date));
    }

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
}
