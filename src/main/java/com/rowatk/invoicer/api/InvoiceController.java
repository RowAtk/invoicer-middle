package com.rowatk.invoicer.api;

import com.rowatk.invoicer.models.common.SimpleResponse;
import com.rowatk.invoicer.models.invoice.Invoice;
import com.rowatk.invoicer.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity addInvoice(@RequestBody Invoice invoice) {
        int id = this.invoiceService.addInvoice(invoice);
        if(id >= 0)
            return ResponseEntity.ok(new SimpleResponse("Invoice id: \'" + id + "\' was added"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("Unable to add invoice"));
    }

    @GetMapping("{invoiceId}")
    public ResponseEntity getInvoiceById(@PathVariable("invoiceId") int id) {
        Optional<Invoice> invoice = this.invoiceService.getInvoiceById(id);
        if(invoice.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No invoice with number: " + id));
        return ResponseEntity.ok(invoice.get());
    }

    @GetMapping
    public ResponseEntity getInvoices() {
        return ResponseEntity.ok(this.invoiceService.getInvoices());
    }

    @DeleteMapping("{invoiceId}")
    public ResponseEntity removeInvoice(@PathVariable("invoiceId") int id) {
        boolean result = this.invoiceService.removeInvoice(id);
        if(result)
            return ResponseEntity.ok(new SimpleResponse("Invoice with number: \'" + id + "\' removed successfully"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No invoice with number: " + id));
    }

    @PutMapping("{invoiceId}")
    public ResponseEntity updateInvoice(@PathVariable("invoiceId") int id, @RequestBody Invoice invoice) {
        if(this.invoiceService.updateInvoice(id, invoice))
            return ResponseEntity.ok(new SimpleResponse("Invoice with number: \'" + id + "\' updated successfully"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No invoice with number: " + id));
    }

}
