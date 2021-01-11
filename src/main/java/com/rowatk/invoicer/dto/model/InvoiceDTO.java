package com.rowatk.invoicer.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rowatk.invoicer.models.invoice.InvoiceBase;

public class InvoiceDTO extends InvoiceBase {

    private int sellerId;
    private int buyerId;
}
