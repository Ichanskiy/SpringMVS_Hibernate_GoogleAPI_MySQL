package com.dao;

import com.entity.AuthorisationUser;

/**
 * Created by Ichanskiy on 2017-05-25.
 */
public interface UserDao<T> {
    void saveUser(T t);
    boolean getUserByPhone(String phone);
    boolean getUser(AuthorisationUser authorisationUser);
}
