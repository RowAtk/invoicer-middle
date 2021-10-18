package com.rowatk.invoicer.dto.model;

public class BuyerDTO extends CompanyDTO {

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getKey() {
        return "Buyer";
    }

    @Override
    public String toString() {
        return "BuyerDTO{" +
                "userId=" + userId +
                ", companyName='" + companyName + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
