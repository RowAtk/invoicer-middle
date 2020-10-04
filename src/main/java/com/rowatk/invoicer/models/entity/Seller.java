package com.rowatk.invoicer.models.entity;

import com.rowatk.invoicer.models.address.Address;

public class Seller extends Entity{

    public Seller(String company_name, Address address, String phone, String email) {
        super(company_name, address, phone, email);
    }

    public String toString() {
        return super.toString("Seller");
    }
}
