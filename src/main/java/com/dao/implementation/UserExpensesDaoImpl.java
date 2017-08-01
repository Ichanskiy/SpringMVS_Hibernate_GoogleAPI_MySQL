package com.dao.implementation;

import com.dao.interfaces.UserExpensesDao;
import com.entity.UserExpenses;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.Map;

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
    public Map<String, Double> getExpensesForTag(Date first, Date second, String phone) {
        Session session = this.sessionFactory.getCurrentSession();
        //Query query = session.createQuery("from UserExpenses join Tag  where user.user_email = ? and user_phone = ?");
        Query query = session.createQuery("from UserExpenses as ue join Tag as t on ue.tagSet");
        System.out.println(query);
        //query.setString(0, authorisationUser.getUser_email());
        //query.setString(1, authorisationUser.getUser_phone());

    return null;
    }


    @Override
    public boolean getUserExpensesById(int id) {
        return false;
    }
}
