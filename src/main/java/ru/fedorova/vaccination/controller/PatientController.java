package ru.fedorova.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fedorova.vaccination.model.dto.PatientDTO;
import ru.fedorova.vaccination.service.PatientService;

import javax.validation.Valid;

/**
 * Контроллер для формы сохранения пациентов
 */
@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;


    /**
     * Гет-метод, возвращает страницу <strong>/patient</strong>
     * @return /patient
     */

    @GetMapping(value = "/patient")
    public String mainForm(Model model) {
        model.addAttribute("patient", new PatientDTO());
        return "patient";
    }


    /**
     * Пост-метод, принимает <strong>patientDTO</strong> из формы со страницы /patient, <br>
     * <em>проверяет</em> корректность заполнения,<br>
     * <em>сохраняет</em> в базу данных с помощью<strong>VaccinationService</strong> <br>
     * и <em>возвращает</em> страницу <strong>/patient</strong> <br>
     * <p>
     * если поля заполнены некорректно <em>возвращает</em> <strong>/patient</strong> с указанием на эти поля
     *
     * @param patientDTO
     * @return /patient
     */

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
