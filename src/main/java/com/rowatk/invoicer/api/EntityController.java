//package com.rowatk.invoicer.api;
//
//import com.rowatk.invoicer.models.common.SimpleResponse;
//import com.rowatk.invoicer.models.entity.Entity;
//import com.rowatk.invoicer.services.EntityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//public abstract class EntityController {
//
//        @Autowired
//        private EntityService entityService;
//
//        @PostMapping
//        public ResponseEntity add(@RequestBody Entity entity) {
//            Long result = this.entityService.addEntity(entity);
//            if(result >= 0) {
//                return ResponseEntity.ok(new SimpleResponse("Entity " + entity.getCompany_name() + " added successfully"));
//            }
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
//                    new SimpleResponse("Unable to add entity " + entity.getCompany_name())
//            );
//        }
//
//        @GetMapping
//        public ResponseEntity getEntities() {
//            return ResponseEntity.ok(this.entityService.getEntitys());
//        }
//
//        @GetMapping("{id}")
//        public ResponseEntity getEntityById(@PathVariable("id") Long id) {
//            Optional<Entity> entity = this.entityService.getEntityById(id);
//            if(entity.isEmpty()) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No entity with ID: " + id));
//            }
//            return ResponseEntity.ok(entity.get());
//        }
//
//        @DeleteMapping("{id}")
//        public ResponseEntity removeEntity(@PathVariable("id") Long id) {
//            Optional<Entity> entity = this.entityService.getEntityById(id);
//            if(entity.isPresent()) {
//                if(this.entityService.removeEntity(id)) {
//                    return ResponseEntity.ok(new SimpleResponse("Entity \'" + entity.get().getCompany_name()+ "\' removed successfully"));
//                }
//            }
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No entity with ID: " + id));
//        }
//
//        @PutMapping("{id}")
//        public ResponseEntity updateEntity(@PathVariable("id") Long id, @RequestBody Entity entity) {
//            if(this.entityService.updateEntity(id, entity)) {
//                return ResponseEntity.ok(new SimpleResponse("Entity with ID \'" + id + "\' updated successfully"));
//            }
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SimpleResponse("No entity with ID: " + id));
//        }
//    }
//
//}
