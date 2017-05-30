package com.dao.interfaces;

import com.entity.UserExpensesTag;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface UserExpansesTagDao {
    void saveUserExpensesTag(UserExpensesTag userExpensesTag);
    boolean getUserExpensesTagByTagName(String name);
    boolean getUserExpensesTagByUserExpensesIdFk(String name);
}
