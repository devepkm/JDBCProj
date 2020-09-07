package com.devepkm.bean;

public class Teacher {
    String id;
    String password;



    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
