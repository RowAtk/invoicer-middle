package com.rowatk.invoicer.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rowatk.invoicer.models.common.Address;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateEntityRequest {

    @JsonProperty("company_name")
    String company_name;

    @JsonProperty("address")
    Address address;

    @JsonProperty("phone")
    String phone;

    @JsonProperty("email")
    String email;

}
