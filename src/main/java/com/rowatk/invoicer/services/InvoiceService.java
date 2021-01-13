package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dto.mappers.InvoiceMapper;
import com.rowatk.invoicer.dto.model.InvoiceDTO;
import com.rowatk.invoicer.dto.requests.CreateInvoiceRequest;
import com.rowatk.invoicer.respositories.InvoiceRepository;
import com.rowatk.invoicer.models.invoice.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class InvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceMapper invoiceMapper;

    public Optional<InvoiceDTO> addInvoice(CreateInvoiceRequest request) {
        InvoiceDTO result = null;

        try {
            // save invoice
            Invoice new_invoice = this.invoiceRepository.save(invoiceMapper.dtoToInvoice(request.getInvoice()));
            result = invoiceMapper.invoiceToDTO(new_invoice);

            // save invoice items
            itemService.saveAll(request.getItems());

        } catch (Exception e) {
            logger.error("Failed to save new invoice: " + e.getMessage());
        }

        return Optional.ofNullable(result);
    }

    public boolean removeInvoice(Long id) {
        this.invoiceRepository.deleteById(id);
        return !this.invoiceRepository.existsById(id);
    }

    public Optional<InvoiceDTO> getInvoiceById(Long id) {
        Optional<Invoice> invoice = this.invoiceRepository.findById(id);
        return invoice.map(inv -> invoiceMapper.invoiceToDTO(inv));
    }

    public Iterable<Invoice> getInvoices() {
        return this.invoiceRepository.findAll();
    }

    public boolean updateInvoice(Long id, Invoice invoice) {
        if(this.invoiceRepository.existsById(id)) {
            invoice.setInvoiceNum(id);
            this.invoiceRepository.save(invoice);
            return true;
        }
        return false;
    }
}
