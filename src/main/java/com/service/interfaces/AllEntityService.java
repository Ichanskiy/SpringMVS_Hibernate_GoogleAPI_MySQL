package com.service.interfaces;

import com.entity.*;

import java.sql.Date;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface AllEntityService {
    void saveAllUserExpansesData(AuthorisationUser authorisationUser, UserExpenses userExpenses, PlacePoint placePoint, Tag tag, UserExpensesTag userExpensesTag);
    void getExpansesForDate (Date first, Date second);
}
