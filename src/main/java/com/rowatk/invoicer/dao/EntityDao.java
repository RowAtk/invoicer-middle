package com.rowatk.invoicer.dao;

import com.rowatk.invoicer.models.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface EntityDao {

    int addEntity(Entity entity);
    boolean removeEntityById(int id);
    Optional<Entity> getEntityById(int id);
    List<Entity> getEntities();
    boolean updateEntity(int id, Entity entity);
}
