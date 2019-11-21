package com.dell.airbnb.entities;

public class Property {
    private int id;
    private String address;
    private int owner_id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOwner_id() {
        return this.owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

}
