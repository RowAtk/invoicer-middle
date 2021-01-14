package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dto.mappers.InvoiceMapper;
import com.rowatk.invoicer.dto.model.InvoiceDTO;
import com.rowatk.invoicer.dto.requests.CreateInvoiceRequest;
import com.rowatk.invoicer.models.invoice.Invoice;
import com.rowatk.invoicer.respositories.InvoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional( rollbackOn = Exception.class )
public class InvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceMapper invoiceMapper;

    public InvoiceDTO addInvoice(CreateInvoiceRequest request) {
        InvoiceDTO result = null;

        try {
            // save invoice
            InvoiceDTO dto = invoiceMapper.requestToDTO(request);
            Invoice new_invoice = this.invoiceRepository.save(invoiceMapper.dtoToInvoice(dto));
            result = invoiceMapper.invoiceToDTO(new_invoice);

            // save invoice items
            itemService.saveAll(request.getItems(), result.getInvoiceNum());

        } catch (Exception e) {
            logger.error("Failed to save new invoice: " + e.getMessage());
            throw e;
        }

        return result;
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

    public boolean updateInvoice(Long id, InvoiceDTO invoiceDTO) {
        if(this.invoiceRepository.existsById(id)) {
            try {
                Invoice invoice = invoiceMapper.dtoToInvoice(invoiceDTO);
                invoice.setInvoiceNum(id);
                this.invoiceRepository.save(invoice);
                return true;
            } catch(Exception e) {
                logger.error("Error updating invoice: " + e.getMessage());
            }
        }
        return false;
    }
}
