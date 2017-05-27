package com.service;

import com.dao.UserDao;
import com.entity.AuthorisationUser;
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
        boolean checkUser = userDao.getUserByPhone(user.getUser_phone());
        System.out.println(checkUser);
        if (checkUser) {
            userDao.saveUser(user);
            return true;
        }else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean authorisationUser(AuthorisationUser authorisationUser) {
        System.out.println("authorisationUser = " + authorisationUser);
        boolean checkUser =  this.userDao.getUser(authorisationUser);
        System.out.println(checkUser);
        return checkUser;
    }
}
