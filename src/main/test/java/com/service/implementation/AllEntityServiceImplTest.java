package com.service.implementation;

import com.dao.implementation.UserDaoImpl;
import com.dao.interfaces.UserDao;
import com.entity.User;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Date;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

/**
 * Created by Ichanskiy on 2017-06-02.
 */

@ContextConfiguration(locations = { "WEB-INF/mvc-dispatcher-servlet.xml" })



public class AllEntityServiceImplTest {
    private UserDao<User> userDao;

    @Autowired
    public void setUserDao(UserDao<User> userDao) {
        this.userDao = userDao;
    }
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @BeforeClass
    public static void setUp() {

    }


    @Test
    public void saveAllUserExpansesData() throws Exception {

        User user = new User("777","ivan","ich@gmail.com");
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(user);
        System.out.println(userService.registrationUser(user));
    }

}