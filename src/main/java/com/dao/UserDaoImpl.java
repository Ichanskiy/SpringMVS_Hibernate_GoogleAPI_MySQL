package com.dao;

import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class UserDaoImpl implements UserDao<User> {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        log.info("User successfully saved. Details: " + user);
    }

    @Override
    public boolean getUserByPhone(int phone) {
        Session session = this.sessionFactory.getCurrentSession();
        System.out.println(phone);
        User user = (User) session.get(User.class, phone);
        System.out.println(user);
        if (user  == null) {
            return  true;
        }else return false;
    }
}
