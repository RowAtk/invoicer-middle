package com.rowatk.invoicer.dto.model;

public class SellerDTO extends EntityDTO{

    @Override
    public String getKey() {
        return "Seller";
    }

    @Override
    public String toString() {
        return super.toString("Seller");
    }
}
