package com.rowatk.invoicer.api;

import com.rowatk.invoicer.models.common.SimpleResponse;
import com.rowatk.invoicer.models.entity.Buyer;
import com.rowatk.invoicer.models.entity.Entity;
import com.rowatk.invoicer.models.entity.Seller;
import com.rowatk.invoicer.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        int result = this.entityService.addBuyer(buyer);
        if(result >= 0) {
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

    @GetMapping("{buyerId}")
    public ResponseEntity getBuyerById(@PathVariable("buyerId") int id) {
        Optional<Buyer> buyer = this.entityService.getBuyerById(id);
        if(buyer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No buyer with ID: " + id));
        }
        return ResponseEntity.ok(buyer.get());
    }

    @DeleteMapping("{buyerId}")
    public ResponseEntity removeBuyer(@PathVariable("buyerId") int id) {
        Optional<Buyer> buyer = this.entityService.getBuyerById(id);
        if(buyer.isPresent()) {
            if(this.entityService.removeBuyer(id)) {
                return ResponseEntity.ok(new SimpleResponse("Buyer \'" + buyer.get().getCompany_name()+ "\' removed successfully"));
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No buyer with ID: " + id));
    }

    @PutMapping("{buyerId}")
    public ResponseEntity updateBuyer(@PathVariable("buyerId") int id, @RequestBody Buyer buyer) {
        if(this.entityService.updateBuyer(id, buyer)) {
            return ResponseEntity.ok(new SimpleResponse("Buyer with ID \'" + id + "\' updated successfully"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No buyer with ID: " + id));
    }
}
