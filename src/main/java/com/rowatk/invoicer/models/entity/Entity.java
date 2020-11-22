package com.rowatk.invoicer.models.entity;

import com.rowatk.invoicer.models.common.Address;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Entity implements Comparable<Entity>{

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String company_name;

    @Embedded
    private Address address;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    public Entity() { }

    public Entity(String company_name, Address address, String phone, String email) {
        this.company_name = company_name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int compareTo(Entity e) {
        int nameCmp = this.company_name.compareTo(e.getCompany_name());
        if(nameCmp == 0) {
            return this.address.compareTo(e.getAddress());
        }
        return nameCmp;
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
