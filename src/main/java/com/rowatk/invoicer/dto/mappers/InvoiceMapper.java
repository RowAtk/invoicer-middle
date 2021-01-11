package com.rowatk.invoicer.dto.mappers;

import com.rowatk.invoicer.dto.model.InvoiceDTO;
import com.rowatk.invoicer.dto.model.InvoiceEntityDTO;
import com.rowatk.invoicer.dto.requests.CreateInvoiceRequest;
import com.rowatk.invoicer.models.invoice.Invoice;

public interface InvoiceMapper {

    Invoice dtoToInvoice(InvoiceDTO dto);

    Invoice dtoToInvoice(InvoiceEntityDTO dto);

    InvoiceDTO invoiceToDTO(Invoice invoice);

    InvoiceEntityDTO invoiceToEntityDTO(Invoice invoice);

    InvoiceDTO requestToDTO(CreateInvoiceRequest request);

}
