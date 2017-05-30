package com.service.implementation;

import com.entity.*;
import com.service.interfaces.AllEntityService;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public class AllEntityServiceImpl implements AllEntityService {


    @Override
    @Transactional
    public void saveallUserExpansesData(AuthorisationUser authorisationUser, UserExpenses userExpenses, PlacePoint placePoint, Tag tag, UserExpensesTag userExpensesTag) {

    }

    @Override
    @Transactional
    public void getExpansesForDate(Date first, Date second) {

    }
}
