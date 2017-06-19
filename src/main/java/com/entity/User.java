package com.entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.*;

/**
 * Created by Ichanskiy on 2017-05-25.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
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



/*  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserExpenses> userExpensesSet = new HashSet<UserExpenses>(0);*/

    public User() {
    }

    public User(String user_phone, String user_name, String user_email, Date user_birthday) {
        this.user_phone = user_phone;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_birthday = user_birthday;
    }

    public User(String user_phone, String user_name, String user_email) {
        this.user_phone = user_phone;
        this.user_name = user_name;
        this.user_email = user_email;
    }

}
