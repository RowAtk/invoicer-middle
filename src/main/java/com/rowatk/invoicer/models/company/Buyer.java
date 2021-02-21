package com.rowatk.invoicer.models.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rowatk.invoicer.models.common.Address;

import javax.persistence.Column;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "buyers")
public class Buyer extends Company {

    private Long userId;

    public Buyer() { }

    public Buyer(
            Long userId,
            String companyName,
            Address address,
            String phone,
            String email) {
        super(companyName, address, phone, email);
        this.userId = userId;

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "userId=" + userId +
                ", id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
