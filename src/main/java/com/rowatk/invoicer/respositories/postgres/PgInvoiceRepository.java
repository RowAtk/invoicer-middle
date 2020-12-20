package com.rowatk.invoicer.respositories.postgres;

import com.rowatk.invoicer.respositories.InvoiceRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository("pgInvoice")
@ConditionalOnProperty(value = "db.mode", havingValue = "pg")
public interface PgInvoiceRepository extends InvoiceRepository {
}
