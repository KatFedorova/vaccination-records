package ru.fedorova.vaccination.service;

import ru.fedorova.vaccination.model.dto.PatientDTO;
import ru.fedorova.vaccination.model.entity.Patient;


import java.sql.Date;

public class PatientService {
    public Patient patDtoToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();

        try {
            Long SNILS = Long.parseLong(patientDTO.getSNILS());
            patient.setSNILS(SNILS);

            String name = patientDTO.getName();
            patient.setName(name);

            String surname = patientDTO.getSurname();
            patient.setSurname(surname);

            String patronymic = patientDTO.getPatronymic();
            patient.setPatronymic(patronymic);

            Date birthDate = Date.valueOf(patientDTO.getBirthDate());
            patient.setBirthDate(birthDate);

            Integer medical_institution_code = Integer.parseInt(patientDTO.getMedical_institution_code());
            patient.setMedical_institution_code(medical_institution_code);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return patient;
    }
}
