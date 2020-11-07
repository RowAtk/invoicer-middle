package com.rowatk.invoicer.api;

import com.rowatk.invoicer.models.common.SimpleResponse;
import com.rowatk.invoicer.models.entity.Seller;
import com.rowatk.invoicer.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sellers")
public class SellerController {

    private final EntityService entityService;

    @Autowired
    public SellerController(EntityService entityService) {
        this.entityService = entityService;
    }

    @PostMapping
    public ResponseEntity addBuyer(@RequestBody Seller seller) {
        boolean result = this.entityService.addSeller(seller);
        if(result) {
            return ResponseEntity.ok(new SimpleResponse("Seller " + seller.getCompany_name() + " added successfully"));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new SimpleResponse("Unable to add seller " + seller.getCompany_name())
        );
    }

    @GetMapping
    public ResponseEntity getSellers() {
        return ResponseEntity.ok(entityService.getSellers());
    }
}
