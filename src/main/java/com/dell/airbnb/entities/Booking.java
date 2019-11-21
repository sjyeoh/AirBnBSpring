package com.dell.airbnb.entities;

import java.util.*;

public class Booking {
    private int id;
    private float price;
    private Date booking_date;
    private String check_in;
    private String check_out;
    private int property_id;
    private int user_id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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

    public int getProperty_id() {
        return this.property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

}