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
import com.entity.subsidary.Information;
import com.entity.subsidary.Result;
import com.service.interfaces.AllEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import java.sql.Date;
import java.util.*;

import static com.Math.Mamdani.Mamdani.getCountEconomy;
import static com.Math.Mamdani.Mamdani.getEconomy;
import static com.Math.Mamdani.Mamdani.getPersent;

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
    public Result Mamdani(Date firstDate, Date secondDate, String phone, double avocation, double clothes, double food) {
        double allSum = 0;
        Map<String, Double> mapExpanses = new HashMap<String, Double>();
        Map<String, Double> resultMap;
        UserExpenses userExpenses;
        List<UserExpenses> list = userExpensesDaoImpl.getExpensesForTag(firstDate, secondDate, phone);
        if (!list.isEmpty()) {
            for (UserExpenses aList : list) {
                userExpenses = aList;
                String name = userExpenses.getTag().getTagName();
                allSum = allSum + userExpenses.getUserexperses_count();
                double count = userExpenses.getUserexperses_count();
                if (mapExpanses.get(name) == null) {
                    mapExpanses.put(name, count);
                } else {
                    double countTmp = mapExpanses.get(name);
                    mapExpanses.put(name, countTmp + count);
                }
            }
        }
        resultMap = getEconomy(mapExpanses, clothes, avocation, food);
        double sum = getCountEconomy(resultMap);
        double persent = getPersent(allSum, sum);
        return new Result(sum, persent, resultMap);
    }

    @Override
    @Transactional
    public void getExpansesForDate(Date first, Date second) {

    }
}
