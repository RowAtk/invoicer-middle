package com.rowatk.invoicer.models.entity;

import com.rowatk.invoicer.models.address.Address;

public abstract class Entity {

    private String company_name;
    private Address address;
    private String phone;
    private String email;

    public Entity(String company_name, Address address, String phone, String email) {
        this.company_name = company_name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
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

    public String toString(String type) {
        return type + "{" +
                "company_name='" + company_name + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
