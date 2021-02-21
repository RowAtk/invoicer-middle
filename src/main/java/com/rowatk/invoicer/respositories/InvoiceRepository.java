package com.rowatk.invoicer.respositories;

import com.rowatk.invoicer.models.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    List<Invoice> findBySellerId(Long sellerId);

}
