package com.rowatk.invoicer.controller;

import com.rowatk.invoicer.dto.model.InvoiceDTO;
import com.rowatk.invoicer.dto.model.ItemDTO;
import com.rowatk.invoicer.dto.responses.ItemListResponse;
import com.rowatk.invoicer.models.common.SimpleResponse;
import com.rowatk.invoicer.models.invoice.Invoice;
import com.rowatk.invoicer.dto.requests.CreateInvoiceRequest;
import com.rowatk.invoicer.services.InvoiceService;
import com.rowatk.invoicer.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity addInvoice(@RequestBody CreateInvoiceRequest request) {
        Optional<InvoiceDTO> invoice = this.invoiceService.addInvoice(request);
        return invoice.map(invoiceDTO -> ResponseEntity.ok(new SimpleResponse("Invoice " + invoiceDTO.getInvoiceNum() + " was added")))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("Unable to add invoice")));
    }

    @GetMapping("{invoiceId}")
    public ResponseEntity getInvoiceById(@PathVariable("invoiceId") Long id) {
        Optional<InvoiceDTO> invoice = this.invoiceService.getInvoiceById(id);
        if(invoice.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No invoice with number: " + id));
        return ResponseEntity.ok(invoice.get());
    }

    @GetMapping
    public ResponseEntity getInvoices() {
        return ResponseEntity.ok(this.invoiceService.getInvoices());
    }

    @DeleteMapping("{invoiceId}")
    public ResponseEntity removeInvoice(@PathVariable("invoiceId") Long id) {
        boolean result = this.invoiceService.removeInvoice(id);
        if(result)
            return ResponseEntity.ok(new SimpleResponse("Invoice " + id + " removed successfully"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No invoice with number: " + id));
    }

    @PutMapping("{invoiceId}")
    public ResponseEntity updateInvoice(@PathVariable("invoiceId") Long id, @RequestBody Invoice invoice) {
        if(this.invoiceService.updateInvoice(id, invoice))
            return ResponseEntity.ok(new SimpleResponse("Invoice " + id + " updated successfully"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No invoice with number: " + id));
    }

    @GetMapping("{invoiceNum}/items")
    public ResponseEntity findInvoiceItems(@PathVariable Long invoiceNum) {
        try {
            List<ItemDTO> items = itemService.findAllByInvoiceNum(invoiceNum);
            ItemListResponse response = new ItemListResponse();
            response.setItems(items);
            return ResponseEntity.ok().body(response);
        } catch(Exception e) {
            logger.error("unable to fetch invoice items: " + e.getMessage());
            return ResponseEntity.badRequest().body(new SimpleResponse("unable to fetch invoice items: " + e.getMessage()));
        }
    }

}
