package ru.fedorova.vaccination.model.dto;

import java.io.Serializable;


public class PatientDTO implements Serializable {

    private String SNILS;
    private String name;
    private String surname;
    private String patronymic;
    private String birthDate;
    private String medical_institution_code;

    public PatientDTO() {
    }

    public PatientDTO(String SNILS, String name, String surname, String patronymic, String birthDate, String medical_institution_code) {
        this.SNILS = SNILS;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.medical_institution_code = medical_institution_code;
    }


    public String getSNILS() {
        return SNILS;
    }

    public void setSNILS(String SNILS) {
        this.SNILS = SNILS;
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

    public String getMedical_institution_code() {
        return medical_institution_code;
    }

    public void setMedical_institution_code(String medical_institution_code) {
        this.medical_institution_code = medical_institution_code;
    }}