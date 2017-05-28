package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by Ichanskiy on 2017-05-25.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_phone")
    private String user_phone;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_email")
    private String user_email;

    @Column(name = "user_birthdate")
    private Date user_birthday;

    public User() {
    }

    public User(String user_phone, String user_name, String user_email, Date user_birthday) {
        this.user_phone = user_phone;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_birthday = user_birthday;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_phone=" + user_phone +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_birthday=" + user_birthday +
                '}';
    }
}
