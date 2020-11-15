package com.rowatk.invoicer.api;

import com.rowatk.invoicer.models.common.SimpleResponse;
import com.rowatk.invoicer.models.entity.Entity;
import com.rowatk.invoicer.models.entity.Seller;
import com.rowatk.invoicer.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/sellers")
public class SellerController {

    private final EntityService entityService;

    @Autowired
    public SellerController(EntityService entityService) {
        this.entityService = entityService;
    }

    @PostMapping
    public ResponseEntity addSeller(@RequestBody Seller seller) {
        int result = this.entityService.addSeller(seller);
        if(result >= 0) {
            return ResponseEntity.ok(new SimpleResponse("Seller \'" + seller.getCompany_name() + "\' added successfully"));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new SimpleResponse("Unable to add seller " + seller.getCompany_name())
        );
    }

    @GetMapping
    public ResponseEntity<List<Entity>> getSellers() {
        return ResponseEntity.ok(entityService.getSellers());
    }

    @GetMapping("{sellerId}")
    public ResponseEntity getSellerById(@PathVariable("sellerId") int id) {
        Optional<Entity> seller = this.entityService.getSellerById(id);
        if(seller.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No seller with ID: " + id));
        }
        return ResponseEntity.ok(seller.get());
    }

    @DeleteMapping("{sellerId}")
    public ResponseEntity removeSeller(@PathVariable("sellerId") int id) {
        Optional<Entity> seller = this.entityService.getSellerById(id);
        if(seller.isPresent()) {
            if(this.entityService.removeSeller(id)) {
                return ResponseEntity.ok(new SimpleResponse("Seller \'" + seller.get().getCompany_name() + "\' removed successfully"));
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No seller with ID: " + id));
    }

    @PutMapping("{sellerId}")
    public ResponseEntity updateSeller(@PathVariable("sellerId") int id, @RequestBody Seller seller) {
        if(this.entityService.updateSeller(id, seller)) {
            return ResponseEntity.ok(new SimpleResponse("Seller with ID \'" + id + "\' updated successfully"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No seller with ID: " + id));
    }
}
