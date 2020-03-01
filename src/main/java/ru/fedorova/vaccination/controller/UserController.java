package ru.fedorova.vaccination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fedorova.vaccination.model.entity.User;
@Controller
public class UserController {


        @GetMapping(value = "/user")
        public String mainForm(Model model) {
            model.addAttribute("user", new User());
            return "user";
        }

}
