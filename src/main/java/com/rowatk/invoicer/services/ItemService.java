package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dto.mappers.ItemMapper;
import com.rowatk.invoicer.dto.model.ItemDTO;
import com.rowatk.invoicer.models.items.Item;
import com.rowatk.invoicer.respositories.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    public Optional<ItemDTO> save(ItemDTO dto) {
        ItemDTO result = null;
        try {
            result = itemMapper.itemToDTO(itemRepository.save(itemMapper.dtoToItem(dto)));
        } catch (Exception e) {
            logger.error("Unable to create item " + dto.getItemId() + " for invoice " + dto.getInvoiceNum());
        }
        return Optional.ofNullable(result);
    }

    public List<ItemDTO> saveAll(List<ItemDTO> dtos) {
        try {
            Iterable<Item> result = itemRepository.saveAll(itemMapper.dtoToItems(dtos));
            return itemMapper.itemsToDTO(result);
        } catch(Exception e) {
            logger.error("Unable to save invoice items: " + e.getMessage());
        }

        return Collections.emptyList();

    }

    public List<ItemDTO> findAllByInvoiceNum(Long invoice_num) {
        List<Item> items = itemRepository.findByInvoiceNum(invoice_num);
        return itemMapper.itemsToDTO(items);
    }

    public Optional<ItemDTO> findOneItem(Long item_id, Long invoice_num) {
        Optional<Item> result = itemRepository.findByItemIdAndInvoiceNum(item_id, invoice_num);
        return result.map(item -> itemMapper.itemToDTO(item));
    }
}
