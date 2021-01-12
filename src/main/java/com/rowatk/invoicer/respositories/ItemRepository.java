package com.rowatk.invoicer.respositories;

import com.rowatk.invoicer.models.items.Item;
import com.rowatk.invoicer.models.items.ItemKey;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, ItemKey> {

    List<Item> findByInvoiceNum(Long inv_num);
    Optional<Item> findByItemIdAndInvoiceNum(Long item_id, Long invoice_num);
}
