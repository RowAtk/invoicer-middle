package com.rowatk.invoicer.dao;

import com.rowatk.invoicer.models.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeEntityDao implements EntityDao{

    public static List<Entity> DB = new ArrayList<>();

    @Override
    public boolean addEntity(Entity entity) {
        try {
            DB.add(entity);
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removeEntityById(int id) {
        for(Entity e : DB) {
            if(e.getId() == id) {
                DB.remove(e);
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Entity> getEntityById(int id) {
        return DB.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    @Override
    public List<Entity> getEntities() {
        return DB;
    }

    @Override
    public boolean updateEntity(int id, Entity entity) {
        return this.getEntityById(id)
                .map(i -> {
                    int index = DB.indexOf(i);
                    if ( index >= 0 ) {
                        DB.set(index, entity);
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }
}
