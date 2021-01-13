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
    protected Long invoiceNum;

    @JsonProperty("issueDate")
    protected Date issueDate;

    @JsonProperty("dueDate")
    protected Date dueDate;

    @JsonProperty("deliveryDate")
    protected Date deliveryDate;

    protected String note;
    protected boolean paid = false;
    protected Status status = Status.OPEN;

    public InvoiceBase() {}

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
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
