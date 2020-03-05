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

import java.util.List;
import java.util.Map;

@Controller
public class VaccinationController {
    @Autowired
    private VaccinationService vaccinationService;

    @GetMapping(value = "/vaccination")
    public String showVaccinations(@PageableDefault(sort = "snils", direction = Sort.Direction.DESC, size = 10) Pageable pageable, Model model) {
        Page<Vaccination> page = vaccinationService.findAll(pageable);
        model.addAttribute("vaccinations", page);
        return "/vaccination";
    }















    @PostMapping(value = "/vaccination")
    public String vaccinationFilter(@RequestParam(name = "filterParam", defaultValue = "15465719692") String filterParam,
                                    Map<String, Iterable> model, @PageableDefault(sort = "snils", direction = Sort.Direction.DESC) Pageable pageable) {
        List<VaccinationDTO> vaccinationViews = vaccinationService.findBySnils(filterParam, pageable);
        model.put("vaccinations", vaccinationViews);
        return "/vaccination";

    }
}
