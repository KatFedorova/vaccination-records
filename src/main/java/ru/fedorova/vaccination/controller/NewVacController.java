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



@Controller
public class NewVacController {
    @Autowired
    private VaccinationRepository vaccinationRepository;


    @GetMapping(value = "/new_vac")
    public String showVaccinations() {
        return "/new_vac";
    }

    @PostMapping(value = "/new_vac")
    public String addVaccination(@RequestParam(name = "snils") String snils,
                                 @RequestParam(name = "consent") Boolean consent,
                                 @RequestParam(name = "date") String date,
                                 @RequestParam(name = "drugId") String drugId,
                                 @RequestParam(name = "workerId") String workerId) {
        VaccinationService vaccinationService = new VaccinationService();
        VaccinationDTO vaccinationDTO = new VaccinationDTO(snils, consent, date, drugId, workerId);
        Vaccination vaccination = vaccinationService.vacDtoToEntity(vaccinationDTO);
        vaccinationRepository.save(vaccination);
        return "/new_vac";

    }
}