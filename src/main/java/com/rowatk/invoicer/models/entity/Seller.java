package com.rowatk.invoicer.models.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rowatk.invoicer.models.common.Address;

import javax.persistence.Table;
import javax.validation.constraints.Email;

@javax.persistence.Entity
@Table(name = "sellers")
public class Seller extends Entity{

    public Seller() {
    }

    public Seller(@JsonProperty("company_name") String company_name,
                  @JsonProperty("address") Address address,
                  @JsonProperty("phone") String phone,
                  @JsonProperty("email") String email) {
        super(company_name, address, phone, email);
    }

    public String toString() {
        return super.toString("Seller");
    }

}
