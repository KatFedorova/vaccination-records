package ru.fedorova.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fedorova.vaccination.model.dto.PatientDTO;
import ru.fedorova.vaccination.repo.PatientRepository;
import ru.fedorova.vaccination.service.PatientService;

import javax.validation.Valid;


@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping(value = "/patient")
    public String mainForm(Model model) {
        model.addAttribute("patient", new PatientDTO());
        return "patient";
    }

    @PostMapping(value = "/patient")
    public String addPatient(@Valid @ModelAttribute("patient") PatientDTO patientDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/patient";
        } else {
            patientService.savePatient(patientDTO);
            return "redirect:/patient";
        }
    }

}
