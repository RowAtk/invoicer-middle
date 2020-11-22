package com.rowatk.invoicer.dao.fake;

import com.rowatk.invoicer.dao.EntityDao;
import com.rowatk.invoicer.models.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class FakeEntityDao implements EntityDao {

    private final List<Entity> DB = new ArrayList<>();

    private int genId() {
        int size = this.DB.size();
        if(size > 0) {
            return this.DB.get(size-1).getId() + 1;
        }
        return 1;
    }

    @Override
    public int addEntity(Entity entity) {
        int id = -1;
        try {
            id = this.genId();
            entity.setId(id);
            DB.add(entity);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return id;
        }
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
