package com.Dao;

import java.sql.SQLException;

/**
 * Created by Ichanskiy on 2017-05-25.
 */
public interface UserDao<T> {
    int saveUser(T t) throws SQLException;
}
