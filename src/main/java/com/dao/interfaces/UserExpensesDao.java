package com.dao.interfaces;

import java.sql.Date;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface UserExpensesDao {

    //void saveUserExpenses(UserExpenses userExpenses);
    boolean getUserExpensesByPeriod(Date first, Date second);
    boolean getUserExpensestById(int id);
}
