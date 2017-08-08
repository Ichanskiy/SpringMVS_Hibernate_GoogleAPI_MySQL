package com.dao.implementation;

import com.dao.interfaces.UserExpensesDao;
import com.entity.UserExpenses;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.*;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public class UserExpensesDaoImpl extends GenericDao implements UserExpensesDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void saveUserExpenses(UserExpenses userExpenses) {
        Session session = getSessionFactory().getCurrentSession();
        session.persist(userExpenses);
        log.info("userExpenses successfully saved. Details: " + userExpenses);
    }

    @Override
    public List<UserExpenses> getExpensesForTag(Date firstDate, Date secondDate, String phone) {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(UserExpenses.class, "ue").setCacheable(false);
        criteria.createAlias("ue.user","u");
        criteria.createAlias("ue.tag","t");
        criteria.add(Restrictions.eq("u.user_phone", phone));
        criteria.add(Restrictions.between("userexperses_date", firstDate, secondDate));
        criteria.setProjection(Projections.projectionList()
//                .add(Projections.groupProperty("t.tag_name")));
                .add(Projections.groupProperty("ue.tag")));
//                .add(Projections.sum("ue.userexperses_count")));
    return criteria.list();
    }


    @Override
    public boolean getUserExpensesById(int id) {
        return false;
    }
}
