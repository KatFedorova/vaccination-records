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
        } catch (Exception e) {
            System.out.println("SNILS is illegal");
        }

        try {
            String name = patientDTO.getName();
            patient.setName(name);
        } catch (Exception e) {
            System.out.println("name is illegal");
        }
        try {
            String surname = patientDTO.getSurname();
            patient.setSurname(surname);
        } catch (Exception e) {
            System.out.println("surname is illegal");
        }
        try {
            String patronymic = patientDTO.getPatronymic();
            patient.setPatronymic(patronymic);
        } catch (Exception e) {
            System.out.println("patronymic is illegal");
        }
        try {
            Date birthDate = Date.valueOf(patientDTO.getBirthDate());
            patient.setBirthDate(birthDate);
        } catch (Exception e) {
            System.out.println("birthDate is illegal");
        }
        try {
            Integer medical_institution_code = Integer.parseInt(patientDTO.getMedical_institution_code());
            patient.setMedical_institution_code(medical_institution_code);
        } catch (Exception e) {
            System.out.println("medical_institution_code is illegal");
        }

        return patient;
    }
}
