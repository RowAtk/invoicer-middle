package com.rowatk.invoicer.dao.postgres;

import com.rowatk.invoicer.dao.EntityRepository;
import com.rowatk.invoicer.dao.InvoiceRepository;
import com.rowatk.invoicer.models.invoice.Invoice;
import org.springframework.stereotype.Repository;

@Repository("pgInvoice")
public interface PgInvoiceRepository extends InvoiceRepository {
}
