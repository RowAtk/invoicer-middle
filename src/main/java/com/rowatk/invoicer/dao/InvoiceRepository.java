package com.rowatk.invoicer.dao;

import com.rowatk.invoicer.models.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InvoiceRepository extends CrudRepository<Invoice, String> {

}
