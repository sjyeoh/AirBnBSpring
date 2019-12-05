package com.dell.airbnb.repositories;

import com.dell.airbnb.entities.Booking;
// import com.dell.airbnb.entities.BookingRowMapper;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.BeanBookingRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;


@Transactional
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}


// public class BookingRepository {
//     private final JdbcTemplate jdbcTemplate;
//     @Autowired
//     public BookingRepository(JdbcTemplate jdbcTemplate) {
// 	  this.jdbcTemplate = jdbcTemplate;
//     }

//     public List<Booking> getAll() {
//         String sql = "SELECT id, price, booking_date, check_in, check_out, property_id, user_id FROM booking";
//         RowMapper<Booking> rowMapper = new BookingRowMapper();
//         return this.jdbcTemplate.query(sql, rowMapper);
//     }

//     public void addBooking(Booking booking){
//         String sql = "INSERT INTO booking ( price, booking_date, check_in, check_out,created_at, updated_at, property_id, user_id) VALUES (?, ?,'9999-99-99','9999-99-99', FORMAT(getdate(), 'yyyy-MM-dd'),FORMAT(getdate(), 'yyyy-MM-dd'), ?, ?)";
//         jdbcTemplate.update(sql, booking.getPrice(),booking.getBooking_date(),booking.getProperty_id(),booking.getUser_id());

//         sql = "SELECT id FROM booking WHERE price = ? AND property_id=? AND user_id = ?";
//         int bookingId = jdbcTemplate.queryForObject(sql, Integer.class,booking.getPrice(),booking.getProperty_id(),booking.getUser_id());

//         booking.setId(bookingId);
//     }
    
//     public void updateBooking(int bookingId,Booking booking) {
//         String sql = "UPDATE booking SET price = ?, booking_date = ?, property_id=?, user_id = ?, check_in = ?, check_out = ? WHERE id = ?";
//         jdbcTemplate.update(sql, booking.getPrice(),booking.getBooking_date(),booking.getProperty_id(),booking.getUser_id(),booking.getCheck_in(),booking.getCheck_out(), bookingId);
//     }
// }