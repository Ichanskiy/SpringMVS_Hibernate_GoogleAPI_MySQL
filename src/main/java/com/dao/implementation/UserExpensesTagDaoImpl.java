package com.dao.implementation;

import com.dao.interfaces.UserExpansesTagDao;
import com.entity.UserExpensesTag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public class UserExpensesTagDaoImpl implements UserExpansesTagDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUserExpensesTag(UserExpensesTag userExpensesTag) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(userExpensesTag);
        log.info("userExpensesTag successfully saved. Details: " + userExpensesTag);
    }

    @Override
    public boolean getUserExpensesTagByTagName(String name) {
        return false;
    }

    @Override
    public boolean getUserExpensesTagByUserExpensesIdFk(String name) {
        return false;
    }
}
