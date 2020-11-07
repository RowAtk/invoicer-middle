package com.rowatk.invoicer.api;

import com.rowatk.invoicer.models.common.SimpleResponse;
import com.rowatk.invoicer.models.entity.Buyer;
import com.rowatk.invoicer.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/buyers")
public class BuyerController {

    private final EntityService entityService;

    @Autowired
    public BuyerController(EntityService entityService) {
        this.entityService = entityService;
    }

    @PostMapping
    public ResponseEntity addBuyer(@RequestBody Buyer buyer) {
        boolean result = this.entityService.addBuyer(buyer);
        if(result) {
            return ResponseEntity.ok(new SimpleResponse("Buyer " + buyer.getCompany_name() + " added successfully"));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new SimpleResponse("Unable to add buyer " + buyer.getCompany_name())
        );
    }

    @GetMapping
    public ResponseEntity getBuyers() {
        return ResponseEntity.ok(entityService.getBuyers());
    }
}
