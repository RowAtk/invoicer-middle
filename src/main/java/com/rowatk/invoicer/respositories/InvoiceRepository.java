package com.rowatk.invoicer.respositories;

import com.rowatk.invoicer.models.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
