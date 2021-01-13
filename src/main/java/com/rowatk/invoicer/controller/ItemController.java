package com.rowatk.invoicer.controller;

import com.rowatk.invoicer.dto.model.ItemDTO;
import com.rowatk.invoicer.dto.responses.ItemListResponse;
import com.rowatk.invoicer.models.common.SimpleResponse;
import com.rowatk.invoicer.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @GetMapping("{invoiceNum}")
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
