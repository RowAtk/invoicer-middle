//package com.rowatk.invoicer.models.invoice;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonSetter;
//import com.rowatk.invoicer.dao.generators.PaddedStringGenerator;
//import com.rowatk.invoicer.models.items.ItemList;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Entity
//@Table(name = "invoices")
//public class InvoiceA {
//
//    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String invoice_num;
//    private String header;
//
//    @JsonProperty("issue_date")
//    private Date issue_date;
//
//    @JsonProperty("due_date")
//    private Date due_date;
//
//    @JsonProperty("delivery_date")
//    private Date delivery_date;
//
//    @JsonProperty("sellerId")
//    private int sellerId;
//
//    @JsonProperty("buyerId")
//    private int buyerId;
//
//    private String note;
//    private boolean paid = false;
//    private Status status = Status.OPEN;
//
//    public InvoiceA() {}
//
//    public InvoiceA(@JsonProperty("issue_date") String issue_date,
//                    @JsonProperty("due_date") String due_date,
//                    @JsonProperty("delivery_date") String delivery_date,
//                    @JsonProperty("sellerId") int sellerId,
//                    @JsonProperty("buyerId") int buyerId,
//                    @JsonProperty("itemList") ItemList itemList) throws ParseException {
//
//        this.setDates(issue_date, due_date, delivery_date);
//        this.sellerId = sellerId;
//        this.buyerId = buyerId;
//        this.paid = false;
//        this.status = Status.OPEN;
//    }
//
//    private void setDates(String issue, String due, String delivery) throws ParseException {
//        this.issue_date = issue_date != null ? dateFormat.parse(issue) : new Date();
//        this.due_date = dateFormat.parse(due);
//        this.delivery_date = dateFormat.parse(delivery);
//    }
//
//    public String getInvoice_num() {
//        return invoice_num;
//    }
//
//    public void setInvoice_num(String invoice_num) {
//        this.invoice_num = invoice_num;
//    }
//
//    public String getHeader() {
//        return header;
//    }
//
//    public void setHeader(String header) {
//        this.header = header;
//    }
//
//    public Date getIssue_date() {
//        return issue_date;
//    }
//
//    public void setIssue_date(Date issue_date) {
//        this.issue_date = issue_date;
//    }
//
//    @JsonSetter("issue_date")
//    public void setIssue_date(String issue_date) throws ParseException {
//        System.out.println("ISSUE DATE: " + issue_date);
//        this.setIssue_date(!issue_date.isBlank() ? dateFormat.parse(issue_date) : new Date());
//    }
//
//    public Date getDue_date() {
//        return due_date;
//    }
//
//    public void setDue_date(Date due_date) {
//        this.due_date = due_date;
//    }
//
//    @JsonSetter("due_date")
//    public void setDue_date(String due_date) throws ParseException {
//        this.setDue_date(dateFormat.parse(due_date));
//    }
//
//    public Date getDelivery_date() {
//        return delivery_date;
//    }
//
//    public void setDelivery_date(Date delivery_date) {
//        this.delivery_date = delivery_date;
//    }
//
//    @JsonSetter("delivery_date")
//    public void setDelivery_date(String delivery_date) throws ParseException {
//        this.setDelivery_date(dateFormat.parse(delivery_date));
//    }
//
//    public int getSellerId() {
//        return sellerId;
//    }
//
//    public void setSellerId(int sellerId) {
//        this.sellerId = sellerId;
//    }
//
//    public int getBuyerId() {
//        return buyerId;
//    }
//
//    public void setBuyerId(int buyerId) {
//        this.buyerId = buyerId;
//    }
//
//    public String getNote() {
//        return note;
//    }
//
//    public void setNote(String note) {
//        this.note = note;
//    }
//
//    public boolean isPaid() {
//        return paid;
//    }
//
//    public void setPaid(boolean paid) {
//        this.paid = paid;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//
//    @Override
//    public String toString() {
//        return "Invoice{" +
//                "invoice_num='" + invoice_num + '\'' +
//                ", header='" + header + '\'' +
//                ", issue_date=" + issue_date +
//                ", due_date=" + due_date +
//                ", delivery_date=" + delivery_date +
//                ", seller=" + sellerId +
//                ", buyer=" + buyerId +
//                ", note='" + note + '\'' +
//                '}';
//    }
//}
//
//
//
