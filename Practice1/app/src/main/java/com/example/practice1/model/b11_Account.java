package com.example.practice1.model;

import java.io.Serializable;

public class b11_Account implements Serializable {
    private String username, password;

    public b11_Account() {
    }

    public b11_Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
