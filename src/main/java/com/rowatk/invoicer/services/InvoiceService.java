package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dao.InvoiceDao;
import com.rowatk.invoicer.models.invoice.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceDao invoiceDao;

    @Autowired
    public InvoiceService(@Qualifier("fakeInvoice") InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }

    public int addInvoice(Invoice invoice){
        return this.invoiceDao.addInvoice(invoice);
    }

    public boolean removeInvoice(int id) {
        return this.invoiceDao.removeInvoiceById(id);
    }

    public Optional<Invoice> getInvoiceById(int id) {
        return this.invoiceDao.getInvoiceById(id);
    }

    public List<Invoice> getInvoices() {
        return this.invoiceDao.getInvoices();
    }

    public boolean updateInvoice(int id, Invoice invoice) {
        return this.invoiceDao.updateInvoice(id, invoice);
    }
}
