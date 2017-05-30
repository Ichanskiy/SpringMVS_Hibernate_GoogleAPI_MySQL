package com.dao.implementation;

import com.dao.interfaces.UserDao;
import com.entity.AuthorisationUser;
import com.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;



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
    public boolean getUserByPhone(String phone) {
        Session session = this.sessionFactory.getCurrentSession();
        System.out.println(phone);
        User user = (User) session.get(User.class, phone);
        System.out.println(user);
        if (user  == null) {
            return  true;
        }else return false;
    }

    @Override
    public boolean getUser(AuthorisationUser authorisationUser) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User as user where user.user_email = ? and user_phone = ?");
        query.setString(0, authorisationUser.getUser_email());
        query.setString(1, authorisationUser.getUser_phone());
        List userList = query.list();
        System.out.println("if user exist --> return true");
        return !userList.isEmpty();
    }
}
