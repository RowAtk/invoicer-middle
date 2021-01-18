package com.rowatk.invoicer.dto.model;

public class BuyerDTO extends EntityDTO {

    @Override
    public String getKey() {
        return "Buyer";
    }

    @Override
    public String toString() {
        return super.toString("Buyer");
    }
}
