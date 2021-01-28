package com.geekbrains.spring.lesson8.controllers;

import com.geekbrains.spring.lesson8.data.UserData;
import com.geekbrains.spring.lesson8.data.UserSadminData;
import com.geekbrains.spring.lesson8.entities.User;
import com.geekbrains.spring.lesson8.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/sadmin_registration")
public class SadminRegistrationController {

    private UserService userService;

    public SadminRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registration(
            Model model
    ){
        model.addAttribute("userSadminData", new UserSadminData());
        return "sadmin_registration";
    }

    @PostMapping
    public String registration(
            @Valid @ModelAttribute UserSadminData userSadminData,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        User user = userService.createUser(userSadminData);
        System.out.println(user);
        return "redirect:/";
    }
}
