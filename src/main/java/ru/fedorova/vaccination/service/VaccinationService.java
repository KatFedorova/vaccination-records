package ru.fedorova.vaccination.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.fedorova.vaccination.model.dto.VaccinationDTO;
import ru.fedorova.vaccination.model.entity.Drug;
import ru.fedorova.vaccination.model.entity.MedicalWorker;
import ru.fedorova.vaccination.model.entity.Vaccination;
import ru.fedorova.vaccination.repo.DrugRepository;
import ru.fedorova.vaccination.repo.MedicalWorkerRepository;
import ru.fedorova.vaccination.repo.VaccinationRepository;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Сервис-класс для манипуляций с Прививками
 */
@Service
public class VaccinationService {
    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private MedicalWorkerRepository medicalWorkerRepository;

    @Autowired
    private VaccinationRepository vaccinationRepository;

    /**
     *  Конвертирует объект vaccinationDTO в Vaccination (парсит все поля)
     * @param vaccinationDTO
     * @return Vaccination
     */
    public Vaccination vacDtoToEntity(VaccinationDTO vaccinationDTO) {
        Vaccination vaccination = new Vaccination();

        Long snils = Long.parseLong(vaccinationDTO.getSnils());
        vaccination.setSnils(snils);

        vaccination.setConsent(vaccinationDTO.getConsent());

        Date date = Date.valueOf(vaccinationDTO.getDate());
        vaccination.setDate(date);

        Integer drugId = Integer.parseInt(vaccinationDTO.getDrugId());
        vaccination.setDrugId(drugId);

        Integer medicalWorkerId = Integer.parseInt(vaccinationDTO.getMedicalWorkerId());
        vaccination.setMedicalWorkerId(medicalWorkerId);

        return vaccination;
    }

    /**  Конвертирует объект Vaccination в vaccinationDTO
     *
     * @param vaccination
     * @return VaccinationDTO
     */
    public VaccinationDTO vacEntityToView(Vaccination vaccination) {
      Drug drug = drugRepository.findByDrugId(vaccination.getDrugId());
      MedicalWorker medicalWorker = medicalWorkerRepository.findByMedicalWorkerId(vaccination.getMedicalWorkerId());

        String snils = String.valueOf(vaccination.getSnils());
        Boolean consent = vaccination.getConsent();
        String date = vaccination.getDate().toString();
        String drugName = vaccination.getDrugId().toString();
        String workerName = vaccination.getMedicalWorkerId().toString();

        return new VaccinationDTO(snils, consent, date, drugName, workerName);
    }

    /**
     * Принимает СНИЛС(строка) в качестве параметра фильтра,
     * если фильтр не пустой, возвращает найденные Прививки в виде страницы;
     * если фильтр пустой, возвращает все прививки в виде страницы
     * @param filterParam
     * @param pageable
     * @return Page <VaccinationDTO>
     */
    public Page <VaccinationDTO> findBySnils(String filterParam, Pageable pageable) {
        Long snils = Long.parseLong(filterParam);


        Page<Vaccination> vaccinations;
      List<VaccinationDTO> vaccinationViews = null;


        if (filterParam != null && !filterParam.isEmpty()) {
            vaccinations = vaccinationRepository.findBySnils(snils,pageable);
        } else {
            vaccinations = vaccinationRepository.findAll(pageable);
        }


        for (Vaccination v :
                vaccinations) {
            VaccinationDTO vaccinationView = vacEntityToView(v);
            vaccinationViews.add(vaccinationView);
        }
        Page<VaccinationDTO> vac =  (Page<VaccinationDTO>)vaccinationViews;

        return vac;
    }

    /**
     * Ищет в базе все прививки, возвращает в виде страницы
     * @param pageable
     * @return
     */
    public Page <Vaccination> findAll(Pageable pageable) {
        Page <Vaccination> vaccinations = vaccinationRepository.findAll(pageable);
        return vaccinations;
    }

    /**
     * Принимает объект vaccinationDTO, конвертирует в Vaccination и сохраняет в БД
     * @param vaccinationDTO
     */
    public void saveVaccination(VaccinationDTO vaccinationDTO) {
        Vaccination vaccination = vacDtoToEntity(vaccinationDTO);
        vaccinationRepository.save(vaccination);
    }

}
