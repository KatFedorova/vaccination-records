package ru.fedorova.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fedorova.vaccination.model.dto.VaccinationDTO;
import ru.fedorova.vaccination.service.VaccinationService;

import javax.validation.Valid;

/**
 * Контроллер для формы сохранения прививок
 */

@Controller
public class NewVacController {
    @Autowired
    private VaccinationService vaccinationService;

    /**
     * Гет-метод, возвращает страницу <strong>/new_vac</strong>
     * @return /new_vac
     */

    @GetMapping(value = "/new_vac")
    public String showVaccinations(Model model) {
        model.addAttribute("vaccination", new VaccinationDTO());
        return "/new_vac";
    }

    /**
     * Пост-метод, принимает <strong>vaccinationDTO</strong> из формы со страницы /new_vac, <br>
     * <em>проверяет</em> корректность заполнения,<br>
     * <em>сохраняет</em> в базу данных с помощью<strong>VaccinationService</strong> <br>
     * и <em>возвращает</em> страницу <strong>/new_vac</strong> <br>
     * <p>
     * если поля заполнены некорректно <em>возвращает</em> <strong>/new_vac</strong> с указанием на эти поля
     *
     * @param vaccinationDTO
     * @return /new_vac
     */

    @PostMapping(value = "/new_vac")
    public String addVaccination(@Valid @ModelAttribute("vaccination") VaccinationDTO vaccinationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/new_vac";
        } else {
            vaccinationService.saveVaccination(vaccinationDTO);
            return "redirect:/new_vac";
        }
    }
}