package com.rowatk.invoicer.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rowatk.invoicer.models.common.Address;

public class CreateEntityRequest {

    @JsonProperty("company_name")
    String company_name;

    @JsonProperty("address")
    Address address;

    @JsonProperty("phone")
    String phone;

    @JsonProperty("email")
    String email;

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
}
