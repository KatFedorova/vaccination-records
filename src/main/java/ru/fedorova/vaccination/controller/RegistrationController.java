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

/**
 * Контроллер для формы регистрации и сохранения пользователя
 *
 */
@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    /**
     * Гет-метод, возвращает страницу <strong>/registration</strong>
     * @return /registration
     */
    @GetMapping(value = "/registration")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    /**
     * Пост-метод, принимает <strong>userDTO</strong> из формы со страницы /registration, <br>
     * <em>проверяет</em> корректность заполнения,<br>
     * <em>сохраняет</em> в базу данных с помощью<strong>UserService</strong> <br>
     * и <em>возвращает</em> страницу <strong>/login</strong> <br>
     * <p>
     * если поля заполнены некорректно <em>возвращает</em> <strong>/registration</strong> с указанием на эти поля
     *
     * @param userDTO
     * @return /registration
     * @return /login
     */
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
