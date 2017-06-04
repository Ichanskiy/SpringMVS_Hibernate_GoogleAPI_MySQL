package com.dao.interfaces;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface UserExpansesTagDao {
   // void saveUserExpensesTag(UserExpensesTag userExpensesTag);
    boolean getUserExpensesTagByTagName(String name);
    boolean getUserExpensesTagByUserExpensesIdFk(String name);
}
