package com.rowatk.invoicer.respositories.postgres;

import com.rowatk.invoicer.respositories.InvoiceRepository;
import org.springframework.stereotype.Repository;

@Repository("pgInvoice")
public interface PgInvoiceRepository extends InvoiceRepository {
}
