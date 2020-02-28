package ru.fedorova.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fedorova.vaccination.model.dto.PatientDTO;
import ru.fedorova.vaccination.model.entity.Patient;
import ru.fedorova.vaccination.repo.PatientRepository;
import ru.fedorova.vaccination.service.PatientService;


@Controller
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(value = "/patient")
    public String mainForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient";
    }

    @PostMapping(value = "/patient")
    public String addPatient(@RequestParam String SNILS,
            @RequestParam (name = "name", required = true)String name,
            @RequestParam (name = "surname", required = true)String surname,
            @RequestParam (name = "patronymic")String patronymic,
            @RequestParam (name = "birthDate")String birthDate,
            @RequestParam (name = "medical_institution_code")String medical_institution_code
    ) {
        PatientService patientService = new PatientService();
        PatientDTO patientDTO = new PatientDTO(SNILS, name, surname, patronymic, birthDate, medical_institution_code);
        Patient patient = patientService.patDtoToEntity(patientDTO);
        patientRepository.save(patient);
        return "/patient";
    }

}
