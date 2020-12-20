package com.rowatk.invoicer.models.common;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Address implements Comparable<Address>{

    @NotBlank
    private String street1;
    private String street2;
    @NotBlank
    private String city;
    @NotBlank
    private String country;
    private String zip;

    public Address() { }

    public Address(String street1, String street2, String city, String country, String zip) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.country = country;
        this.zip = zip;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public int compareTo(Address a) {
        int st1 = this.street1.compareTo(a.getStreet1());
        if(st1 == 0) {
            int st2 = this.street2.compareTo(a.getStreet2());
            if(st2 == 0) {
                int city = this.city.compareTo(a.getCity());
                if(city == 0) {
                    int country = this.country.compareTo(a.getCountry());
                    if (country == 0) {
                        int zip = this.zip.compareTo(a.getZip());
                        return zip;
                    }
                    return country;
                }
                return city;
            }
            return st2;
        }
        return st1;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
