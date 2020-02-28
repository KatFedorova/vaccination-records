package ru.fedorova.vaccination.service;


import org.springframework.beans.factory.annotation.Autowired;
import ru.fedorova.vaccination.model.dto.VaccinationDTO;
import ru.fedorova.vaccination.model.entity.Drug;
import ru.fedorova.vaccination.model.entity.MedicalWorker;
import ru.fedorova.vaccination.model.entity.Vaccination;
import ru.fedorova.vaccination.repo.DrugRepository;
import ru.fedorova.vaccination.repo.MedicalWorkerRepository;
import ru.fedorova.vaccination.repo.VaccinationRepository;

import java.sql.Date;
import java.util.List;

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
            Long SNILS = Long.parseLong(vaccinationDTO.getSNILS());
            vaccination.setSNILS(SNILS);

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

        String SNILS = String.valueOf(vaccination.getSNILS());
        Boolean consent = vaccination.getConsent();
        String date = vaccination.getDate().toString();
        String drug_name = drug.getName();
        String worker_name = medicalWorker.getSurname() + " " + medicalWorker.getName();


        VaccinationDTO vaccinationDTO = new VaccinationDTO(SNILS, consent, date, drug_name, worker_name);
        return vaccinationDTO;
    }

    public List <VaccinationDTO> findBySNILS(String filterParam) {
        Long SNILS = Long.parseLong(filterParam);


        Iterable <Vaccination> vaccinations;
        List <VaccinationDTO> vaccinationViews = null;


        if (filterParam != null && ! filterParam.isEmpty()) {
            vaccinations = vaccinationRepository.findBySNILS(SNILS);
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


}
