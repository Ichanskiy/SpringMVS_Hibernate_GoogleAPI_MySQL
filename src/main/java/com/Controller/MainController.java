package com.controller;


import com.dto.DTO;
import com.entity.subsidary.AuthorisationUser;
import com.entity.User;
import com.entity.subsidary.Information;
import com.service.interfaces.AllEntityService;
import com.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/**
 * Created by Ichanskiy on 2017-05-25.
 */

@Controller
@SessionAttributes("authorisationUser")
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserService<User> userService;

    @Autowired
    private AllEntityService allEntityService;



    @RequestMapping(value = "/LogIn", method = RequestMethod.GET)
    public String showLogInPage(Model model){
        System.out.println("1");
        model.addAttribute("authorisationUser", new AuthorisationUser());
        return "LogIn";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "Registration";
    }

    @RequestMapping(value = "expenses", method = RequestMethod.POST)
    public String authorisation(@ModelAttribute("authorisationUser")AuthorisationUser authorisationUser) {
        System.out.println(authorisationUser);

        if (this.userService.authorisationUser(authorisationUser)){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("authorisationUser", authorisationUser);
            return "redirect:/Expenses";
        } else {
            return "Error";
        }
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

    @RequestMapping(value = "Expenses", method = RequestMethod.GET)
    public String showExpansesPage(@ModelAttribute("authorisationUser") AuthorisationUser AuthorisationUser, Model model) {
        System.out.println("AuthorisationUser = " + AuthorisationUser);
        model.addAttribute("dto", new DTO());
        model.addAttribute("informationData", new Information());
        return "Expenses";
    }

    @RequestMapping(value = "/expenses/add", method = RequestMethod.POST)
    public String addExpanses(@ModelAttribute("dto") DTO dto, @ModelAttribute ("authorisationUser") AuthorisationUser authorisationUser) {
        System.out.println(dto);
        allEntityService.saveAllUserExpansesData(dto, authorisationUser.getUser_phone());
        return "redirect:/Expenses";
    }

    @RequestMapping(value = "/expenses/dateInfo", method = RequestMethod.GET)
    public String showInfoDate(@ModelAttribute("authorisationUser") AuthorisationUser user, @ModelAttribute("informationData") Information information) {

        Map hashMapTegExpenses;
        Map<String, Double> removeTag;

        hashMapTegExpenses = allEntityService.Mamdani(information.getFirstDate(), information.getSecondDate(), user.getUser_phone());

        return "Result";
    }
}