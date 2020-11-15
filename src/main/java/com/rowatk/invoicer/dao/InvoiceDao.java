package com.rowatk.invoicer.dao;

import com.rowatk.invoicer.models.invoice.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceDao {

    int addInvoice(Invoice invoice);
    boolean removeInvoiceById(int id);
    Optional<Invoice> getInvoiceById(int id);
    List<Invoice> getInvoices();
    boolean updateInvoice(int id, Invoice invoice);
}
