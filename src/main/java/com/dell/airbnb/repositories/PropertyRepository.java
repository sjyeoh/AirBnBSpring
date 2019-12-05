package com.dell.airbnb.repositories;

import com.dell.airbnb.entities.Property;
import com.dell.airbnb.entities.PropertyRowMapper;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class PropertyRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PropertyRepository(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }

    public List<Property> getAll() {
        String sql = "SELECT id, address, owner_id FROM property";
        RowMapper<Property> rowMapper = new PropertyRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public void addProperty(Property property){
        String sql = "INSERT INTO property (address, owner_id, created_at, updated_at) VALUES ( ?, ?, FORMAT(getdate(), 'yyyy-MM-dd'), FORMAT(getdate(), 'yyyy-MM-dd'))";
        jdbcTemplate.update(sql, property.getAddress(),property.getOwner_id());

        sql = "SELECT id FROM property WHERE address = ? AND owner_id = ?";
        int propertyId = jdbcTemplate.queryForObject(sql, Integer.class,property.getAddress(),property.getOwner_id());

        property.setId(propertyId);
    }
    
    public void updateProperty(int propertyId,Property property) {
        String sql = "UPDATE property SET address = ?, owner_id = ? WHERE id=?";
        jdbcTemplate.update(sql, property.getAddress(),property.getOwner_id(), propertyId);
    }
}