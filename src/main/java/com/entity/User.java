package com.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by Ichanskiy on 2017-05-25.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {

    public static final String USER_PHONE = "user_phone";
    public static final String USER_NAME = "user_name";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_BIRTHDAY = "user_birthdate";

    @Id
    @Column(name = USER_PHONE)
    private String user_phone;

    @Column(name = USER_NAME)
    private String user_name;

    @Column(name = USER_EMAIL)
    private String user_email;

    @Column(name = USER_BIRTHDAY)
    private Date user_birthday;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserExpenses> userExpensesSet/* = new HashSet<UserExpenses>(0)*/;

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
