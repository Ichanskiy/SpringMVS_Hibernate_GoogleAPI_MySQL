package com.dao.interfaces;

import com.entity.UserExpenses;

import java.sql.Date;
import java.util.Map;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface UserExpensesDao {

    void saveUserExpenses(UserExpenses userExpenses);
    Map getExpensesForTag(Date first, Date second, String phone);
    boolean getUserExpensesById(int id);
}
