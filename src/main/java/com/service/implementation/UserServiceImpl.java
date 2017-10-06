package com.service.implementation;

import com.dao.implementation.UserDaoImpl;
import com.dao.interfaces.UserDao;
import com.entity.subsidary.AuthorisationUser;
import com.entity.User;
import com.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService<User> {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserDao<User> userDao;

    @Override
    @Transactional
    public boolean registrationUser(User user) {
        boolean checkUser = userDao.getUserByPhone(user.getUser_phone());
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
        log.info("authorisationUser = " + authorisationUser);
        return this.userDao.getUser(authorisationUser);
    }

    @Override
    public User getUserById(String id ) {
        return userDao.getUserById(id);
    }
}
