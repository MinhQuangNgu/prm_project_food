package com.example.order_food.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "password")
    public String password;
    @ColumnInfo(name = "role")
    public String role = "user";

    public User(int uid, String name, String email, String password) {
        this.id = uid;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User(){

    }

    public int getUid() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
