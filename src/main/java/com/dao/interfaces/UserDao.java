package com.dao.interfaces;

import com.entity.subsidary.AuthorisationUser;
import com.entity.User;

/**
 * Created by Ichanskiy on 2017-05-25.
 */
public interface UserDao<T> {
    void saveUser(T t);
    boolean getUserByPhone(String phone);
    boolean getUser(AuthorisationUser authorisationUser);
    User getUserById(String id);
}
