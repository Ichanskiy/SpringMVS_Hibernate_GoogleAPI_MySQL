package com.service.interfaces;

import com.entity.AuthorisationUser;
import com.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by Ichanskiy on 2017-05-26.
 */
public interface UserService<T> {

    boolean registrationUser(T t);
    boolean authorisationUser(AuthorisationUser authorisationUser);
    User getUserById(String id);
}
