package ru.fedorova.vaccination.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.fedorova.vaccination.model.dto.VaccinationDTO;
import ru.fedorova.vaccination.model.entity.Drug;
import ru.fedorova.vaccination.model.entity.MedicalWorker;
import ru.fedorova.vaccination.model.entity.Vaccination;
import ru.fedorova.vaccination.repo.DrugRepository;
import ru.fedorova.vaccination.repo.MedicalWorkerRepository;
import ru.fedorova.vaccination.repo.VaccinationRepository;

import java.sql.Date;
import java.util.List;
@Component
public class VaccinationService {
    @Autowired
    DrugRepository drugRepository;

    @Autowired
    MedicalWorkerRepository medicalWorkerRepository;

    @Autowired
    private VaccinationRepository vaccinationRepository;

    public Vaccination vacDtoToEntity(VaccinationDTO vaccinationDTO) {
        Vaccination vaccination = new Vaccination();
        try {
            Long snils = Long.parseLong(vaccinationDTO.getSnils());
            vaccination.setSnils(snils);

            vaccination.setConsent(vaccinationDTO.getConsent());

            Date date = Date.valueOf(vaccinationDTO.getDate());
            vaccination.setDate(date);

            Integer drugId = Integer.parseInt(vaccinationDTO.getDrugId());
            vaccination.setDrugId(drugId);

            Integer medicalWorkerId = Integer.parseInt(vaccinationDTO.getMedicalWorkerId());
            vaccination.setMedicalWorkerId(medicalWorkerId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vaccination;
    }

    public VaccinationDTO vacEntityToView(Vaccination vaccination) {
        Drug drug = drugRepository.findByDrugId(vaccination.getDrugId());
        MedicalWorker medicalWorker = medicalWorkerRepository.findByMedicalWorkerId(vaccination.getMedicalWorkerId());

        String snils = String.valueOf(vaccination.getSnils());
        Boolean consent = vaccination.getConsent();
        String date = vaccination.getDate().toString();
        String drugName = drug.getName();
        String workerName = medicalWorker.getSurname() + " " + medicalWorker.getName();


        VaccinationDTO vaccinationDTO = new VaccinationDTO(snils, consent, date, drugName, workerName);
        return vaccinationDTO;
    }

    public List <VaccinationDTO> findBySnils(String filterParam) {
        Long snils = Long.parseLong(filterParam);


        Iterable <Vaccination> vaccinations;
        List <VaccinationDTO> vaccinationViews = null;


        if (filterParam != null && ! filterParam.isEmpty()) {
            vaccinations = vaccinationRepository.findBySnils(snils);
        } else {
            vaccinations = vaccinationRepository.findAll();
        }


        for (Vaccination v :
                vaccinations) {
            VaccinationDTO vaccinationView = vacEntityToView(v);
            vaccinationViews.add(vaccinationView);
        }
        List <VaccinationDTO> vac = (List <VaccinationDTO>) vaccinationViews;

        return vac;
    }

    public Iterable<Vaccination> findAll() {
        Iterable<Vaccination> vaccinations = vaccinationRepository.findAll();
        return vaccinations;
    }


    public void saveVaccination(VaccinationDTO vaccinationDTO) {
        Vaccination vaccination = vacDtoToEntity(vaccinationDTO);
        vaccinationRepository.save(vaccination);
    }




}
