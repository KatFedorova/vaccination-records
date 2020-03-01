package ru.fedorova.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fedorova.vaccination.model.dto.VaccinationDTO;
import ru.fedorova.vaccination.model.entity.Vaccination;
import ru.fedorova.vaccination.repo.VaccinationRepository;
import ru.fedorova.vaccination.service.VaccinationService;


import java.util.List;
import java.util.Map;

@Controller
public class VaccinationController {
    @Autowired
    private VaccinationRepository vaccinationRepository;



    @GetMapping(value = "/vaccination")
    public String showVaccinations(Map<String, Object> model) {
        Iterable <Vaccination> vaccinations = vaccinationRepository.findAll();

        model.put("vaccinations", vaccinations);
        return "/vaccination";
    }

     @PostMapping(value = "/vaccination")
     public String vaccinationFilter(@RequestParam(name = "filterParam", defaultValue = "15465719692") String filterParam,
                                     Map<String, Iterable> model) {
   //     Long SNILS = Long.parseLong(filterParam);
//
//
   //     Iterable<Vaccination> vaccinations;
   //     if (filterParam != null && !filterParam.isEmpty()) {
   //         vaccinations = vaccinationRepository.findBySNILS(SNILS);
   //     } else {
   //         vaccinations = vaccinationRepository.findAll();
   //     }

     VaccinationService vaccinationService = new VaccinationService();
      List<VaccinationDTO> vaccinationViews = vaccinationService.findBySNILS(filterParam);
        model.put("vaccinations", vaccinationViews);
         return "/vaccination";

     }
}
