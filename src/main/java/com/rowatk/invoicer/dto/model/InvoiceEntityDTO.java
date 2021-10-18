package com.rowatk.invoicer.dto.model;

import com.rowatk.invoicer.dto.DTO;
import com.rowatk.invoicer.models.invoice.InvoiceBase;

public class InvoiceEntityDTO extends InvoiceBase implements DTO {

    private UserDTO user;
    private BuyerDTO buyer;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public BuyerDTO getBuyer() {
        return buyer;
    }

    public void setBuyer(BuyerDTO buyer) {
        this.buyer = buyer;
    }

    @Override
    public String getKey() {
        return "invoice";
    }

    @Override
    public String toString() {
        return "InvoiceEntityDTO{" +
                "user=" + user +
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
