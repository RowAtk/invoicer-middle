package com.rowatk.invoicer.models.items;

import java.io.Serializable;
import java.util.Objects;

public class ItemKey implements Serializable {

    protected Long itemId;
    protected Long invoiceNum;

    public ItemKey() {
    }

    public ItemKey(Long itemId, Long invoiceNum) {
        this.itemId = itemId;
        this.invoiceNum = invoiceNum;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(Long invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemKey itemKey = (ItemKey) o;
        return Objects.equals(itemId, itemKey.itemId) && Objects.equals(invoiceNum, itemKey.invoiceNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, invoiceNum);
    }

    @Override
    public String toString() {
        return "ItemKey{" +
                "itemId=" + itemId +
                ", invoiceNum=" + invoiceNum +
                '}';
    }
}
