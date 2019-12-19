package com.dell.airbnb.repositories;

import com.dell.airbnb.entities.User;
// import com.dell.airbnb.entities.UserRowMapper;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByName(String name);
    User findByEmail(String email);
    
}


// public class UserRepository {
//     private final JdbcTemplate jdbcTemplate;
//     @Autowired
//     public UserRepository(JdbcTemplate jdbcTemplate) {
// 	  this.jdbcTemplate = jdbcTemplate;
//     }

//     public List<User> getAll() {
//         String sql = "SELECT id, name, email,contact_no FROM [user]";
//         RowMapper<User> rowMapper = new UserRowMapper();
//         return this.jdbcTemplate.query(sql, rowMapper);
//     }

//     public void addUser(User user){
//         String sql = "INSERT INTO [user] (name, email, contact_no, created_at, updated_at) VALUES (?, ?, ?, FORMAT(getdate(), 'yyyy-MM-dd'),FORMAT(getdate(), 'yyyy-MM-dd'))";
//         jdbcTemplate.update(sql, user.getName(),user.getEmail(),user.getContact_no());

//         sql = "SELECT id FROM [user] WHERE name = ? AND email = ? AND contact_no = ?";
//         int userId = jdbcTemplate.queryForObject(sql, Integer.class,user.getName(),user.getEmail(),user.getContact_no());

//         user.setId(userId);
//     }
    
//     public void updateUser(int userId,User user) {
//         String sql = "UPDATE [user] SET name=?, email=?,contact_no=? WHERE id=?";
//         jdbcTemplate.update(sql, user.getName(),user.getEmail(),user.getContact_no(), userId);
//     }
// }