package com.controller;


import com.entity.User;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Ichanskiy on 2017-05-25.
 */

@Controller
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    private UserService<User> userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService<User> userService) {
        this.userService = userService;
    }



    @RequestMapping(value = "/LogIn", method = RequestMethod.GET)
    public String showLogInPage(Model model){
        System.out.println("1");
        return "LogIn";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "Registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user) {

        System.out.println(user);
        log.info("user = " + user);
        if (this.userService.registrationUser(user)) {
            System.out.println("successfully");
            return "redirect:/LogIn";
        } else {
            return "Error";
        }
    }
}

