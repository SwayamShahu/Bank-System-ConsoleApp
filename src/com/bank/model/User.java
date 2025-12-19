package com.bank.model;

import com.bank.util.IdGenerator;

public class User {
    private String userId;
    private String name;
    private String mobileNumber;
    private String address;
    private String email;

    IdGenerator idg = new IdGenerator();
    public User(String name, String mobileNumber, String address, String email) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.email = email;
        this.userId = idg.generateUserId();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
