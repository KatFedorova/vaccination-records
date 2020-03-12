package ru.fedorova.vaccination.controller;

import ru.fedorova.vaccination.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *Основной контроллер, выводит страницу аккаунта пользователя
 *
 */

@Controller
public class MainController {

    /**
     * Гет-метод, возвращает <strong>/user</strong>
     * @return /user
     */
    @GetMapping(value = "/")
    public String mainForm(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }
}