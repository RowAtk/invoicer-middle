package com.rowatk.invoicer.controller;

import com.rowatk.invoicer.dto.DTO;
import com.rowatk.invoicer.dto.model.EntityDTO;
import com.rowatk.invoicer.dto.responses.ApiResponse;
import com.rowatk.invoicer.dto.responses.ApiResponseFactory;
import com.rowatk.invoicer.dto.responses.ListResponse;
import com.rowatk.invoicer.models.common.SimpleResponse;
import com.rowatk.invoicer.models.entity.Entity;
import com.rowatk.invoicer.services.EntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class EntityController<T extends Entity, D extends EntityDTO> {

    private static final Logger logger = LoggerFactory.getLogger(EntityController.class);

    @Autowired
    private EntityService<T, D> entityService;
    
    private String type() {
        return this.entityService.getType();
    }

    @PostMapping
    public ResponseEntity add(@RequestBody D dto) {
        logger.info("Attempting to save {}", type());
        Optional<D> result = this.entityService.add(dto);
        if(result.isPresent()) {
            logger.info("Successfully saved " + type());
            return ResponseEntity.ok(new SimpleResponse(type() + " " + result.get().getCompanyName() + " added successfully"));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new SimpleResponse("Unable to add " + type())
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getEntities() {
        List<D> result = this.entityService.findAll();
        System.out.println(result);
        return ApiResponseFactory.ok(new ListResponse((List<DTO>) result, type() + "s"));
//        return ResponseEntity.ok(this.entityService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEntityById(@PathVariable("id") Long id) {
        D entity = this.entityService.findById(id);
        return ApiResponseFactory.ok(entity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> removeEntity(@PathVariable("id") Long id) {
        D entity = this.entityService.findById(id);
        entityService.removeById(id);
        return ApiResponseFactory.ok(null, type() + " '" + entity.getCompanyName() + "' removed successfully");
    }

    @PutMapping("{id}")
    public ResponseEntity updateEntity(@PathVariable("id") Long id, @RequestBody D entity) {
        if(this.entityService.updateById(id, entity)) {
            return ResponseEntity.ok(new SimpleResponse(type() + " with ID '" + id + "' updated successfully"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No " + type() + " with ID: " + id));
    }
}
