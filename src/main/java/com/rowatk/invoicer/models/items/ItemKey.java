package com.rowatk.invoicer.models.items;

import java.io.Serializable;
import java.util.Objects;

public class ItemKey implements Serializable {

    protected Long item_id;
    protected Long invoice_num;

    public ItemKey() {
    }

    public ItemKey(Long item_id, Long invoice_num) {
        this.item_id = item_id;
        this.invoice_num = invoice_num;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Long getInvoice_num() {
        return invoice_num;
    }

    public void setInvoice_num(Long invoice_num) {
        this.invoice_num = invoice_num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemKey itemKey = (ItemKey) o;
        return Objects.equals(item_id, itemKey.item_id) && Objects.equals(invoice_num, itemKey.invoice_num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, invoice_num);
    }
}
