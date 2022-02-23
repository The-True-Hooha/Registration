package com.TheTrueHooha.UserRegistration.Controllers;

import com.TheTrueHooha.UserRegistration.Repository.UserRepository;
import com.TheTrueHooha.UserRegistration.User.UserParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

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

    @PostMapping("/success")
    public String postRegistration(UserParameters userParameters) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encrypt = encoder.encode(userParameters.getPassword());
        userParameters.setPassword(encrypt);


        userRepository.save(userParameters);
        return "success";
    }

    @GetMapping("/users")
    public String listUser (Model model){
        List <UserParameters> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }
}
