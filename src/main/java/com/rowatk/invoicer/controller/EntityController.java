package com.rowatk.invoicer.controller;

import com.rowatk.invoicer.models.common.SimpleResponse;
import com.rowatk.invoicer.models.entity.Entity;
import com.rowatk.invoicer.services.EntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public abstract class EntityController<T extends Entity> {

    private static final Logger logger = LoggerFactory.getLogger(EntityController.class);

    @Autowired
    private EntityService<T> entityService;
    
    private String type() {
        return this.entityService.getType();
    }

    @PostMapping
    public ResponseEntity add(@RequestBody T entity) {
        logger.info("Attempting to save {}", type());
        T result = this.entityService.add(entity);
        if(result != null) {
            logger.info("Successfully saved " + type());
            return ResponseEntity.ok(new SimpleResponse(type() + " " + entity.getCompany_name() + " added successfully"));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new SimpleResponse("Unable to add " + type())
        );
    }

    @GetMapping
    public ResponseEntity getEntities() {
        return ResponseEntity.ok(this.entityService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity getEntityById(@PathVariable("id") Long id) {
        Optional<T> entity = this.entityService.findById(id);
        if(entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No " + type() + " with ID: " + id));
        }
        return ResponseEntity.ok(entity.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity removeEntity(@PathVariable("id") Long id) {
        Optional<T> entity = this.entityService.findById(id);
        if(entity.isPresent()) {
            if(this.entityService.removeById(id)) {
                return ResponseEntity.ok(new SimpleResponse(type() + " \'" + entity.get().getCompany_name()+ "\' removed successfully"));
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No " + type() + " with ID: " + id));
    }

    @PutMapping("{id}")
    public ResponseEntity updateEntity(@PathVariable("id") Long id, @RequestBody T entity) {
        if(this.entityService.updateById(id, entity)) {
            return ResponseEntity.ok(new SimpleResponse(type() + " with ID \'" + id + "\' updated successfully"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No " + type() + " with ID: " + id));
    }
}
