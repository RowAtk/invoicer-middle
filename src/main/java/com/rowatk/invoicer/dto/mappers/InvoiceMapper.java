package com.rowatk.invoicer.dto.mappers;

import com.rowatk.invoicer.dto.model.InvoiceDTO;
import com.rowatk.invoicer.dto.model.InvoiceEntityDTO;
import com.rowatk.invoicer.dto.requests.CreateInvoiceRequest;
import com.rowatk.invoicer.models.invoice.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface InvoiceMapper {

    Invoice dtoToInvoice(InvoiceDTO dto);

    Invoice dtoToInvoice(InvoiceEntityDTO dto);

    InvoiceDTO invoiceToDTO(Invoice invoice);

    InvoiceEntityDTO invoiceToEntityDTO(Invoice invoice);

    @Mapping( target = ".", source = "invoice")
    InvoiceDTO requestToDTO(CreateInvoiceRequest request);

}
