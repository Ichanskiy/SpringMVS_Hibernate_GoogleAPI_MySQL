package com.dao.implementation;

import com.dao.interfaces.UserExpensesDao;
import com.entity.UserExpenses;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public class UserExpensesDaoImpl implements UserExpensesDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUserExpenses(UserExpenses userExpenses) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(userExpenses);
        log.info("userExpenses successfully saved. Details: " + userExpenses);
    }

    @Override
    public boolean getUserExpensesByPeriod(Date first, Date second) {
        return false;
    }

    @Override
    public boolean getUserExpensestById(int id) {
        return false;
    }
}
