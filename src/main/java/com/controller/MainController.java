package com.controller;


import com.dto.DTO;
import com.entity.subsidary.AuthorisationUser;
import com.entity.User;
import com.entity.subsidary.Information;
import com.entity.subsidary.Result;
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
        model.addAttribute("dto", new DTO());
        model.addAttribute("informationData", new Information());
        return "Expenses";
    }

    @RequestMapping(value = "/expenses/add", method = RequestMethod.POST)
    public String addExpanses(@ModelAttribute("dto") DTO dto, @ModelAttribute ("authorisationUser") AuthorisationUser authorisationUser) {
        allEntityService.saveAllUserExpansesData(dto, authorisationUser.getUser_phone());
        return "redirect:/Expenses";
    }

    @RequestMapping(value = "/expenses/dateInfo", method = RequestMethod.POST)
    public String showInfoDate(@ModelAttribute("authorisationUser") AuthorisationUser authorisationUser, @ModelAttribute("informationData") Information information,  Model model) {

        Result result = allEntityService
                .Mamdani(information.getFirstDate(), information.getSecondDate(), authorisationUser.getUser_phone(),
                        information.getAvocation(), information.getClothes(), information.getFood());
        result.setPointList(allEntityService.route(information.getFirstDate(), information.getSecondDate(), authorisationUser.getUser_phone()));
        model.addAttribute("result", result);
        return "Result";
    }

    @RequestMapping(value = "/expenses/possibility/dateInfo", method = RequestMethod.GET)
    public String showResult(@ModelAttribute("authorisationUser") AuthorisationUser authorisationUser, @ModelAttribute("result") Result result, ModelAndView modelAndView, Model model) {
        System.out.println(result);
        model.addAttribute("result", result);
        return "Result";
    }
}