package com.dao;

import com.entity.AuthorisationUser;

import java.sql.SQLException;

/**
 * Created by Ichanskiy on 2017-05-25.
 */
public interface UserDao<T> {
    void saveUser(T t);
    boolean getUserByPhone(int phone);
    boolean getUser(AuthorisationUser authorisationUser);
}
