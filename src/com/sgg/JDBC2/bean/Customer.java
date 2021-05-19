package com.sgg.JDBC2.bean;

import java.sql.Blob;
import java.util.Date;

public class Customer {
    private String name;
    private String email;
    private Date birth;
    private Blob photo;
    private int id;
    public Customer(){}

    public Customer(String name, String email, Date birth) {
        this.name = name;
        this.email = email;
        this.birth = birth;
    }
    public String getId() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", photo=" + photo +
                ", id=" + id +
                '}';
    }
}
