package com.rowatk.invoicer.controller;

import com.rowatk.invoicer.dto.model.CompanyDTO;
import com.rowatk.invoicer.dto.responses.ApiResponse;
import com.rowatk.invoicer.dto.responses.ApiResponseFactory;
import com.rowatk.invoicer.dto.responses.GeneralResponse;
import com.rowatk.invoicer.models.common.SimpleResponse;
import com.rowatk.invoicer.models.company.Company;
import com.rowatk.invoicer.services.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class CompanyController<T extends Company, D extends CompanyDTO> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected CompanyService<T, D> companyService;
    
    private String type() {
        return this.companyService.getType();
    }

    @PostMapping
    public ResponseEntity add(@RequestBody D dto) {
        logger.info("Attempting to save {}", type());
        Optional<D> result = this.companyService.add(dto);
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
        List<D> result = this.companyService.findAll();
        return ApiResponseFactory.ok(new GeneralResponse(type() + "s", result));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEntityById(@PathVariable("id") Long id) {
        D entity = this.companyService.findById(id);
        return ApiResponseFactory.ok(entity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> removeEntity(@PathVariable("id") Long id) {
        D entity = this.companyService.findById(id);
        companyService.removeById(id);
        return ApiResponseFactory.ok(null, type() + " '" + entity.getCompanyName() + "' removed successfully");
    }

    @PutMapping("{id}")
    public ResponseEntity updateEntity(@PathVariable("id") Long id, @RequestBody D entity) {
        if(this.companyService.updateById(id, entity)) {
            return ResponseEntity.ok(new SimpleResponse(type() + " with ID '" + id + "' updated successfully"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No " + type() + " with ID: " + id));
    }
}
