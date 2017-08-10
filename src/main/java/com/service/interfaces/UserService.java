package com.service.interfaces;

import com.entity.subsidary.AuthorisationUser;
import com.entity.User;

/**
 * Created by Ichanskiy on 2017-05-26.
 */

public interface UserService<T> {

    boolean registrationUser(T t);
    boolean authorisationUser(AuthorisationUser authorisationUser);
    User getUserById(String id);
}
