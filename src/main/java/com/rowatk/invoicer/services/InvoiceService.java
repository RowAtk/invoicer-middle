package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dao.InvoiceRepository;
import com.rowatk.invoicer.models.invoice.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(@Qualifier("fakeInvoice") InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice addInvoice(Invoice invoice){
        return this.invoiceRepository.save(invoice);
    }

    public boolean removeInvoice(String id) {
        this.invoiceRepository.deleteById(id);
        return !this.invoiceRepository.existsById(id);
    }

    public Optional<Invoice> getInvoiceById(String id) {
        return this.invoiceRepository.findById(id);
    }

    public Iterable<Invoice> getInvoices() {
        return this.invoiceRepository.findAll();
    }

    public boolean updateInvoice(String id, Invoice invoice) {
        if(this.invoiceRepository.existsById(id)) {
            invoice.setInvoice_num(id);
            this.invoiceRepository.save(invoice);
            return true;
        }
        return false;
    }
}
