package com.rowatk.invoicer.dao;

import com.rowatk.invoicer.models.invoice.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeInvoice")
public class FakeInvoiceDao implements InvoiceDao {

    private static List<Invoice> DB = new ArrayList<>();

    private int genId() {
        int size = this.DB.size();
        if(size > 0) {
            return this.DB.get(size-1).getInvoice_num() + 1;
        }
        return 1;
    }

    @Override
    public int addInvoice(Invoice invoice) {
        int id = -1;
        try {
            id = this.genId();
            invoice.setInvoice_num(id);
            DB.add(invoice);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return id;
        }
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
