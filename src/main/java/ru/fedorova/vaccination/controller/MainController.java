package ru.fedorova.vaccination.controller;

import ru.fedorova.vaccination.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {



    @GetMapping(value = "/")
    public String mainForm(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

  //  @PostMapping(value = "/")
  //  public String mainSubmit(@ModelAttribute User user) {
//
  //      return "redirect:/user";
  //  }

}