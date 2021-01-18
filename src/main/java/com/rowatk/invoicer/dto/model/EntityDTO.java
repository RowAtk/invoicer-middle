package com.rowatk.invoicer.dto.model;

import com.rowatk.invoicer.dto.DTO;
import com.rowatk.invoicer.models.common.Address;

public abstract class EntityDTO implements DTO {
    protected String companyName;
    protected Address address;
    protected String phone;
    protected String email;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getKey() {
        return "Entity";
    }

    public String toString(String name) {
        return name + "DTO{" +
                "company_name='" + companyName + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
