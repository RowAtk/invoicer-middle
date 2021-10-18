package com.rowatk.invoicer.dto.model;

import com.rowatk.invoicer.dto.DTO;
import com.rowatk.invoicer.models.common.Address;

public abstract class CompanyDTO implements DTO {
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
}
