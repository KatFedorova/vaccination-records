package ru.fedorova.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fedorova.vaccination.model.dto.PatientDTO;
import ru.fedorova.vaccination.model.entity.Patient;
import ru.fedorova.vaccination.repo.PatientRepository;

import java.sql.Date;
@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

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

    public void savePatient(PatientDTO patientDTO) {
        patientDTO.setMedicalInstitutionCode("720001");
        Patient patient = patDtoToEntity(patientDTO);
        patientRepository.save(patient);
    }
}
