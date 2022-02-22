package com.TheTrueHooha.UserRegistration.Controllers;

import com.TheTrueHooha.UserRegistration.User.UserParameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    //http rest method to get data
    @GetMapping("")
    public String homePage () {
        return "index";
    }

    @GetMapping("/register")
    public String registerForm (Model model){
        model.addAttribute("user", new UserParameters());
        return "registerForm";
    }
}
