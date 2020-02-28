package ru.fedorova.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fedorova.vaccination.model.entity.MedicalWorker;
import ru.fedorova.vaccination.model.entity.User;
import ru.fedorova.vaccination.repo.UserRepository;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/registration")
    public String showForm(Model model) {
      //  model.addAttribute("user", new User());
      //  model.addAttribute("medical_worker", new MedicalWorker());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String addUser(@RequestParam(name = "name") String name,
                          @RequestParam(name = "password") String password) {
        User user = new User(name, password, 2, "USER");
       // User userFromDb = userRepository.findByName(name);
        if (name != null && !name.isEmpty()) {
            userRepository.save(user);
        } else {
        }
        return "registration";
}}

//&& !userFromDb.getName().equals(name)