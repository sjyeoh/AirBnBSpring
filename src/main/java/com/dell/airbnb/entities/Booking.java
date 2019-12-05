package com.dell.airbnb.entities;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="booking")

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private float price;

    @Column
    private Date booking_date;

    @Column
    private String check_in;
    
    @Column
    private String check_out;
    
    @Column
    private Long property_id;
    
    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer user_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // @Column
    // private Long user_id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getBooking_date() {
        return this.booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public String getCheck_in() {
        return this.check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return this.check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public Long getProperty_id() {
        return this.property_id;
    }

    public void setProperty_id(Long property_id) {
        this.property_id = property_id;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}