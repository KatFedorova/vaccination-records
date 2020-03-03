package ru.fedorova.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fedorova.vaccination.model.dto.UserDTO;
import ru.fedorova.vaccination.model.entity.User;
import ru.fedorova.vaccination.service.UserService;
import javax.validation.Valid;


@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/registration")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String addUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/registration";
        } else {
            userService.saveUser(userDTO);
            return "redirect:/login";
        }
    }
}
