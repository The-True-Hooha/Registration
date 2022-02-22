package com.TheTrueHooha.UserRegistration.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    //http rest method to get data
    @GetMapping("")
    public String homePage () {
        return "index";
    }

}
