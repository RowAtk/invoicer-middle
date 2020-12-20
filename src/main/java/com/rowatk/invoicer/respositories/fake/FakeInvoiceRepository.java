package com.rowatk.invoicer.respositories.fake;

import com.rowatk.invoicer.respositories.InvoiceRepository;
import com.rowatk.invoicer.models.invoice.Invoice;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeInvoice")
public class FakeInvoiceRepository implements InvoiceRepository {

    private List<Invoice> DB = new ArrayList<>();

    private Long genId() {
        int size = this.DB.size();
        if(size > 0) {
            return this.DB.get(size-1).getInvoice_num() + 1;
        }
        return 1L;
    }

    @Override
    @NonNull
    public <S extends Invoice> S save(@NonNull S s) {
        Long id = null;
        try {
            id = this.genId();
            s.setInvoice_num(id);
            DB.add(s);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return s;
    }

    @Override
    @NonNull
    public Optional<Invoice> findById(@NonNull Long inv_num) {
        return this.DB.stream()
                .filter(invoice -> invoice.getInvoice_num().equals(inv_num))
                .findFirst();
    }

    @Override
    public boolean existsById(@NonNull Long inv_num) {
        return this.DB.stream()
                .anyMatch(invoice -> invoice.getInvoice_num().equals(inv_num));
    }

    @Override
    @NonNull
    public Iterable<Invoice> findAll() {
        return this.DB;
    }

    @Override
    public long count() {
        return this.DB.size();
    }

    @Override
    public void deleteById(@NonNull Long inv_num) {
        this.DB.removeIf(inv -> inv.getInvoice_num().equals(inv_num));
    }

    @Override
    public void deleteAll() {
        this.DB.clear();
    }

    @Override
    public <S extends Invoice> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Iterable<Invoice> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public void delete(Invoice invoice) {

    }

    @Override
    public void deleteAll(Iterable<? extends Invoice> iterable) {

    }
}
