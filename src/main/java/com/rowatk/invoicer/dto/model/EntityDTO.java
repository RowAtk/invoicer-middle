package com.rowatk.invoicer.dto.model;

import com.rowatk.invoicer.models.common.Address;

public abstract class EntityDTO {
    protected String company_name;
    protected Address address;
    protected String phone;
    protected String email;

    public String toString(String name) {
        return name + "DTO{" +
                "company_name='" + company_name + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
