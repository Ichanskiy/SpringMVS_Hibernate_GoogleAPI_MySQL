package com.service.implementation;

import com.dao.interfaces.UserDao;
import com.entity.subsidary.AuthorisationUser;
import com.entity.User;
import com.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService<User> {

    @Autowired
    private UserDao<User> userDao;

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

    @Override
    public User getUserById(String id ) {
        return null;
    }
}
