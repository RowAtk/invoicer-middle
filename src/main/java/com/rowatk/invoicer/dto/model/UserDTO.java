package com.rowatk.invoicer.dto.model;

public class UserDTO extends CompanyDTO {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getKey() {
        return "User";
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "companyName='" + companyName + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
