package com.dell.airbnb.repositories;

import com.dell.airbnb.entities.Payment;
import com.dell.airbnb.entities.PaymentRowMapper;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPaymentRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class PaymentRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PaymentRepository(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }

    public List<Payment> getAll() {
        String sql = "SELECT id, status, amount, booking_id FROM payment";
        RowMapper<Payment> rowMapper = new PaymentRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public void addPayment(Payment payment){
        String sql = "INSERT INTO payment ( status, amount, booking_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, payment.getStatus(),payment.getAmount(),payment.getBooking_id());

        sql = "SELECT id FROM payment WHERE status = ? AND amount = ? AND booking_id = ?";
        int paymentId = jdbcTemplate.queryForObject(sql, Integer.class,payment.getStatus(),payment.getAmount(),payment.getBooking_id());

        payment.setId(paymentId);
    }
    
    public void updatePayment(int paymentId,Payment payment) {
        String sql = "UPDATE payment SET status = ?, amount = ?, booking_id = ? WHERE id=?";
        jdbcTemplate.update(sql, payment.getStatus(),payment.getAmount(),payment.getBooking_id(), paymentId);
    }
}