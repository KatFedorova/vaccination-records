package ru.fedorova.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fedorova.vaccination.model.dto.PatientDTO;
import ru.fedorova.vaccination.model.entity.Patient;
import ru.fedorova.vaccination.repo.PatientRepository;
/**
 * Сервис-класс для манипуляций с Пациентами
 *
 */
import java.sql.Date;
@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;


    /**
     * Конвертирует объект patientDTO в Patient (парсит все поля)
     * @param patientDTO
     * @return Patient
     */
    public Patient patDtoToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();

            Long snils = Long.parseLong(patientDTO.getSnils());
            patient.setSnils(snils);

            String name = patientDTO.getName();
            patient.setName(name);

            String surname = patientDTO.getSurname();
            patient.setSurname(surname);

            String patronymic = patientDTO.getPatronymic();
            patient.setPatronymic(patronymic);

            Date birthDate = Date.valueOf(patientDTO.getBirthDate());
            patient.setBirthDate(birthDate);

            Integer medicalInstitutionCode = Integer.parseInt(patientDTO.getMedicalInstitutionCode());
            patient.setMedicalInstitutionCode(medicalInstitutionCode);

        return patient;
    }

    /**
     * Принимает обект patientDTO, конвертирует в Patient и сохраняет в БД
     * @param patientDTO
     */
    public void savePatient(PatientDTO patientDTO) {
        patientDTO.setMedicalInstitutionCode("720001");
        Patient patient = patDtoToEntity(patientDTO);
        patientRepository.save(patient);
    }
}
