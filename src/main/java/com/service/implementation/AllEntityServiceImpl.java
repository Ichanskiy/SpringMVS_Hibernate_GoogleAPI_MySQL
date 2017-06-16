package com.service.implementation;

import com.dao.interfaces.*;
import com.entity.*;
import com.service.interfaces.AllEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
@Service
public class AllEntityServiceImpl implements AllEntityService {

    @Autowired
    private PlacePointDao placePointDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    UserDao<User> userDao;

    @Autowired
    private UserExpensesDao userExpensesDao;

    @Autowired
    private UserExpansesTagDao userExpansesTagDao;

    @Override
    @Transactional
    public void saveAllUserExpansesData(AuthorisationUser authorisationUser, UserExpenses userExpenses, PlacePoint placePoint, Tag tag, UserExpensesTag userExpensesTag) {
        placePointDao.savePlacePoint(placePoint);
        //placePointDao.getPalacePointById()
    }

    @Override
    @Transactional
    public void getExpansesForDate(Date first, Date second) {

    }
}
