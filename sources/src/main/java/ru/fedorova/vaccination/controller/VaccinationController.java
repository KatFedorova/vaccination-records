package ru.fedorova.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fedorova.vaccination.model.dto.VaccinationDTO;
import ru.fedorova.vaccination.model.entity.Vaccination;
import ru.fedorova.vaccination.service.VaccinationService;

/**
 * Контроллер для страницы вывода всех прививок и по фильтру СНИЛС
 */

@Controller
public class VaccinationController {
    @Autowired
    private VaccinationService vaccinationService;

    /**
     * Метод для постраничного <em>вывода</em> всех вакцинаций (10 прививок на страницу). <br>
     * <em>Ищет</em> все вакцинации  с помощью <strong>VaccinationService</strong> <br>
     * и <em>возвращает</em> страницу <strong>/vaccination</strong> с результатами
     * @param pageable
     * @param model
     * @return /vaccination
     */
    @GetMapping(value = "/vaccination")
    public String showVaccinations(@PageableDefault(sort = "snils", direction = Sort.Direction.DESC, size = 10) Pageable pageable, Model model) {
        Page<Vaccination> page = vaccinationService.findAll(pageable);
        model.addAttribute("vaccinations", page);
        return "/vaccination";
    }



    /**
     * Метод работает не корректно
     * Должен принимать параметр фильтра и через vaccinationService находить нужные значения
     */


    @PostMapping(value = "/vaccination")
    public String vaccinationFilter(@RequestParam(name = "filterParam", defaultValue = "15465719692") String filterParam,
                                    Model model, @PageableDefault(sort = "snils", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<VaccinationDTO> vaccinationViews = vaccinationService.findBySnils(filterParam, pageable);
        model.addAttribute("vaccinations", vaccinationViews);
        return "/vaccination";

    }
}
