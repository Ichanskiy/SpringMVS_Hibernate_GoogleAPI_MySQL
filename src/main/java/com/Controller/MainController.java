package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Created by Ichanskiy on 2017-05-25.
 */


@Controller
public class MainController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Model model){
        System.out.println("sdf");
        String mes = "helllo";
        model.addAttribute("message", mes);

        return "index";
    }
}
