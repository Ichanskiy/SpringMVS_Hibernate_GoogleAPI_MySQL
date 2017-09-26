package com.service.implementation;

import com.dao.implementation.UserExpensesDaoImpl;
import com.dao.interfaces.PlacePointDao;
import com.dao.interfaces.TagDao;
import com.dao.interfaces.UserDao;
import com.dao.interfaces.UserExpensesDao;
import com.dto.DTO;
import com.entity.Tag;
import com.entity.User;
import com.entity.UserExpenses;
import com.service.interfaces.AllEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import java.sql.Date;
import java.util.*;

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
    private UserExpensesDaoImpl userExpensesDaoImpl;

    @Override
    @Transactional
    public void saveAllUserExpansesData(DTO dto, String idUser) {

        int id = placePointDao.savePlacePoint(dto.getPlacePoint());
        System.out.println("idPlacePoint = " + id);

        UserExpenses userExpenses = new UserExpenses();
        userExpenses.setUserexperses_count(dto.getUserExpenses().getUserexperses_count());
        userExpenses.setUserexperses_date(dto.getUserExpenses().getUserexperses_date());
        userExpenses.setUserexpenses_id(id);
        userExpenses.setUser(userDao.getUserById(idUser));
        userExpenses.setTag(dto.getTag());
        userExpensesDao.saveUserExpenses(userExpenses);

        Tag tag = new Tag();
        tag.setTagDiscripton("disc");
        tag.setTagName(dto.getTag().getTagName());
        tag.setTagNameParent(dto.getTag().getTagNameParent());
        tagDao.saveTag(tag);
    }

    @Override
    public Map Mamdani(Date firstDate, Date secondDate, String phone) {

        List<UserExpenses> list = userExpensesDaoImpl.getExpensesForTag(firstDate, secondDate, phone);
        System.out.println(list.size());
        return null;
    }

    @Override
    @Transactional
    public void getExpansesForDate(Date first, Date second) {

    }
}
