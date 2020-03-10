package ru.vlsu.animalSpecification.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.service.SecurityService;
import ru.vlsu.animalSpecification.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @GetMapping(value = "/registration")
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        return "account/registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
        userService.save(userForm);
        securityService.autoLogin(userForm.getUserName(), userForm.getPassword());
        return "redirect:/index";
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "INCORRECT");
        }

        if(logout != null) {
            model.addAttribute("SUCCESS");
        }
        return "login";
    }


}
