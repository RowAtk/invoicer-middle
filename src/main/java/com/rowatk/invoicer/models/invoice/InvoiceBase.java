package com.rowatk.invoicer.models.invoice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@MappedSuperclass
public abstract class InvoiceBase {

    @Transient
    protected final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long invoiceNum;

    @JsonProperty("issueDate")
    protected Date issueDate;

    @JsonProperty("dueDate")
    protected Date dueDate;

    @JsonProperty("deliveryDate")
    protected Date deliveryDate;

    protected String note;
    protected boolean paid = false;

    @Enumerated(EnumType.STRING)
    protected Status status = Status.OPEN;

    public InvoiceBase() {}

    public Long getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(Long invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @JsonSetter("issueDate")
    public void setIssueDate(String issueDate) throws ParseException {
        System.out.println("ISSUE DATE: " + issueDate);
        this.setIssueDate(!issueDate.isBlank() ? dateFormat.parse(issueDate) : new Date());
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @JsonSetter("dueDate")
    public void setDueDate(String dueDate) throws ParseException {
        this.setDueDate(dateFormat.parse(dueDate));
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @JsonSetter("deliveryDate")
    public void setDeliveryDate(String deliveryDate) throws ParseException {
        this.setDeliveryDate(dateFormat.parse(deliveryDate));
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
