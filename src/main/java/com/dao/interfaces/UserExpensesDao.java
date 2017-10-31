package com.dao.interfaces;

import com.entity.UserExpenses;

import java.util.*;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface UserExpensesDao {

    void saveUserExpenses(UserExpenses userExpenses);
    List getUserExpensesForTag(Date first, Date second, String phone);
    List<UserExpenses> getUserExpensesById(int id);
    List<UserExpenses> getUserExpensesAll(String phone);
}
