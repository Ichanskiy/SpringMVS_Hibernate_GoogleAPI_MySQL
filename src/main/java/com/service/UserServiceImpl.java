package com.service;

import com.dao.UserDao;
import com.entity.User;
import org.springframework.transaction.annotation.Transactional;


public class UserServiceImpl implements  UserService<User> {

    private UserDao<User> userDao;

    public void setUserDao(UserDao<User> userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public boolean registrationUser(User user) {
        System.out.println("1");
        boolean checkUser = userDao.getUserByPhone(user.getUser_phone());
        System.out.println("2");
        System.out.println(checkUser);
        if (checkUser) {
            System.out.println("true");
            userDao.saveUser(user);
            System.out.println("save dao");
            return true;
        }else {
            System.out.println("not save");
            System.out.println("return false");
            return false;
        }
    }
}
