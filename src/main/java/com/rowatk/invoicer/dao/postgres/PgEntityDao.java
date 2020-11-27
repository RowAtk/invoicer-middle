package com.rowatk.invoicer.dao.postgres;

import com.rowatk.invoicer.dao.EntityDao;
import com.rowatk.invoicer.models.entity.Entity;
import com.rowatk.invoicer.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public abstract class PgEntityDao implements EntityDao {

    private final String table;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public PgEntityDao(String table) {
        this.table = table;
    }

    @Override
    public int addEntity(Entity entity) {
        return 0;
    }

    @Override
    public boolean removeEntityById(int id) {
        return false;
    }

    @Override
    public Optional<Entity> getEntityById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Entity> getEntities() {
        String sql = "SELECT * from " + table;
//        PreparedStatement ps =
        return null;
    }

    @Override
    public boolean updateEntity(int id, Entity entity) {
        return false;
    }
}
