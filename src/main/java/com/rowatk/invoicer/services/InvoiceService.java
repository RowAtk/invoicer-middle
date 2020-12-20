package com.rowatk.invoicer.services;

import com.rowatk.invoicer.respositories.InvoiceRepository;
import com.rowatk.invoicer.models.invoice.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice addInvoice(Invoice invoice){
        return this.invoiceRepository.save(invoice);
    }

    public boolean removeInvoice(Long id) {
        this.invoiceRepository.deleteById(id);
        return !this.invoiceRepository.existsById(id);
    }

    public Optional<Invoice> getInvoiceById(Long id) {
        return this.invoiceRepository.findById(id);
    }

    public Iterable<Invoice> getInvoices() {
        return this.invoiceRepository.findAll();
    }

    public boolean updateInvoice(Long id, Invoice invoice) {
        if(this.invoiceRepository.existsById(id)) {
            invoice.setInvoice_num(id);
            this.invoiceRepository.save(invoice);
            return true;
        }
        return false;
    }
}
