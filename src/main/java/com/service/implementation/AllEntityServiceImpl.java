package com.service.implementation;

import com.dao.interfaces.*;
import com.dto.DTO;
import com.entity.*;
import com.service.interfaces.AllEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
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
    public void saveAllUserExpansesData(DTO dto, String idUser) {


        int id = placePointDao.savePlacePoint(dto.getPlacePoint());
        System.out.println("idPlacePoint = " + id);

        UserExpenses userExpenses = new UserExpenses();
        userExpenses.setUserExpensesCount(dto.getUserExpenses().getUserExpensesCount());
        userExpenses.setUserExpensesDate(dto.getUserExpenses().getUserExpensesDate());
        //userExpenses.setUserPhoneFk(idUser);
        userExpenses.setUserExpensesId(id);
        userExpenses.setPlacePointIdFk(id);
        userExpenses.setUser(userDao.getUserById(idUser));

        userExpensesDao.saveUserExpenses(userExpenses);

        //userExpenses.setUser(userDao.getUserById(idUser));
        //userExpenses.setUser();
        //System.out.println(userExpenses);

        UserExpensesTag userExpensesTag = new UserExpensesTag();
        userExpensesTag.setUserExpensesIdFk(id);
        userExpensesTag.setTagNameFk(dto.getTag().getTagNameParent());
        System.out.println("userExpensesTag" + userExpensesTag);
        userExpansesTagDao.saveUserExpensesTag(userExpensesTag);
    }

    @Override
    @Transactional
    public void getExpansesForDate(Date first, Date second) {

    }
}
