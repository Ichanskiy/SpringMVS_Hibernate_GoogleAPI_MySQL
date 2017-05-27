package com.service;

import java.sql.SQLException;

/**
 * Created by Ichanskiy on 2017-05-26.
 */
public interface UserService<T> {

    boolean registrationUser(T t);

}
