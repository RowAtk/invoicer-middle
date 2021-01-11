package com.rowatk.invoicer.dto.mappers;

import com.rowatk.invoicer.dto.model.ItemDTO;
import com.rowatk.invoicer.dto.requests.CreateInvoiceRequest;
import com.rowatk.invoicer.models.items.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ItemMapper {

    Item dtoToItem(ItemDTO dto);

    ItemDTO itemToDTO(Item item);

    @Mapping(target = ".", source = "items")
    Iterable<ItemDTO> requestToDTO(Iterable<Item> items);
}
