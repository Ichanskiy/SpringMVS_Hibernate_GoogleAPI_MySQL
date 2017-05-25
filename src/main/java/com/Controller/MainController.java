package com.Controller;

import com.Dao.UserDaoImpl;
import com.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.annotation.ModelFactory;


/**
 * Created by Ichanskiy on 2017-05-25.
 */


@Controller
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    private UserDaoImpl userDao;

    @Autowired(required = true)
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "/LogIn", method = RequestMethod.GET)
    public String showLogInPage(Model model){
        return "LogIn";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "Registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user){

        System.out.println(user);
        log.info("user = " + user);
        this.userDao.saveUser(user);
        System.out.println("successfully");
        return "redirect:/registration";
    }



}
