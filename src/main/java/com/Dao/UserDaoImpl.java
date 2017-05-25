package com.Dao;

import com.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ichanskiy on 2017-05-25.
 */
public class UserDaoImpl implements UserDao<User> {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int saveUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        log.info("User successfully saved. Details: " + user);
        return 0;
    }
}
