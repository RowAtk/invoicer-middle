package com.rowatk.invoicer.models.company;

import com.rowatk.invoicer.models.common.Address;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Company implements Comparable<Company>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotBlank
    protected String companyName;

    @Embedded
    protected Address address;

    @NotNull
    protected String phone;

    @NotNull
    protected String email;

    public Company() { }

    public Company(String companyName, Address address, String phone, String email) {
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    public int compareTo(Company e) {
        int nameCmp = this.companyName.compareTo(e.getCompanyName());
        if(nameCmp == 0) {
            return this.address.compareTo(e.getAddress());
        }
        return nameCmp;
    }
}
