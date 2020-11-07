package com.rowatk.invoicer.dao;

import com.rowatk.invoicer.models.invoice.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeInvoice")
public class FakeInvoiceDao implements InvoiceDao {

    private static List<Invoice> DB = new ArrayList<>();

    @Override
    public boolean addInvoice(Invoice invoice) {
        DB.add(invoice);
        return true;
    }

    @Override
    public boolean removeInvoiceById(int id) {
        for(Invoice i : DB) {
            if(i.getInvoice_num() == (id)) {
                DB.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Invoice> getInvoiceById(int id) {
        return DB.stream()
                .filter(invoice -> invoice.getInvoice_num() == id)
                .findFirst();
    }

    @Override
    public List<Invoice> getInvoices() {
        return DB;
    }

    @Override
    public boolean updateInvoice(int id, Invoice invoice) {
        return this.getInvoiceById(id)
                .map(i -> {
                    int index = DB.indexOf(i);
                    if ( index >=0 ) {
                        DB.set(index, invoice);
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }
}
