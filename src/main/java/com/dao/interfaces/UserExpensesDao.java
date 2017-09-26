package com.dao.interfaces;

import com.entity.UserExpenses;

import java.util.*;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface UserExpensesDao {

    void saveUserExpenses(UserExpenses userExpenses);
    List getExpensesForTag(Date first, Date second, String phone);
    boolean getUserExpensesById(int id);
}
