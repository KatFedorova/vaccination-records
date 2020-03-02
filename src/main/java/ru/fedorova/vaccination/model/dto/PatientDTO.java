package ru.fedorova.vaccination.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


public class PatientDTO implements Serializable {

    @NotNull
    private String snils;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 16)
    private String name;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 16)
    private String surname;
    private String patronymic;
    @NotNull
    private String birthDate;
    private String medicalInstitutionCode;

    public PatientDTO() {
    }

    public PatientDTO(String snils, String name, String surname, String patronymic, String birthDate, String medicalInstitutionCode) {
        this.snils = snils;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.medicalInstitutionCode = medicalInstitutionCode;
    }

    public PatientDTO(String snils, String name, String surname, String patronymic, String birthDate) {
        this.snils = snils;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
    }


    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getMedicalInstitutionCode() {
        return medicalInstitutionCode;
    }

    public void setMedicalInstitutionCode(String medicalInstitutionCode) {
        this.medicalInstitutionCode = medicalInstitutionCode;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "SNILS='" + snils + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", medical_institution_code='" + medicalInstitutionCode + '\'' +
                '}';
    }
}