package com.demoshop.models;

public class User {
    
    private  String name;
    private  String lastName;
    private  String email;
    private  String password;
    private  String confirmationPassword;

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Guest setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }
}
