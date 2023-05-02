package com.example.secondjavaee.db;

import java.sql.PreparedStatement;

public class Admins {
    private Long id;
    private String email;
    private String password;
    private String full_name;

    public Admins() {
    }

    public Admins(Long id, String email, String password, String full_name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.full_name = full_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

}
