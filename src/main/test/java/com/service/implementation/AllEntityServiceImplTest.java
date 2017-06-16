package com.service.implementation;

import com.dao.implementation.UserDaoImpl;
import com.dao.interfaces.UserDao;
import com.entity.User;
import com.service.interfaces.UserService;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Ichanskiy on 2017-06-05.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:mvc-dispatcher-servlet.xml")
@Transactional
public class AllEntityServiceImplTest {


    private UserService<User> userService;

    @Autowired
    public void setUserService(UserService<User> userService) {
        this.userService = userService;
    }

    @Test
    public void saveAllUserExpansesData() throws Exception {
        User user = new User("dfg", "dfg", "dffg");

        this.userService.registrationUser(user);
        System.out.println("successfully");
    }

}