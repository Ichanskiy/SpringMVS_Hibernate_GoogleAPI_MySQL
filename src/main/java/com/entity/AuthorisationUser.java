package com.entity;

/**
 * Created by Ichanskiy on 2017-05-27.
 */
public class AuthorisationUser extends User {
    
    private String user_phone;
    private String user_email;

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    @Override
    public String toString() {
        return "AuthorisationUser{" +
                "user_phone='" + user_phone + '\'' +
                ", user_email='" + user_email + '\'' +
                '}';
    }
}
