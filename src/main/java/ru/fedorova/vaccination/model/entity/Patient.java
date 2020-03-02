package ru.fedorova.vaccination.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private Integer patientId;
    @Column(name = "SNILS")
    private Long snils;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "medical_institution_code")
    private Integer medicalInstitutionCode;

    public Patient() {
    }

    public Patient(Long snils, String name, String surname, String patronymic, Date birthDate, Integer medicalInstitutionCode) {
        this.snils = snils;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.medicalInstitutionCode = medicalInstitutionCode;
    }

    public Patient(Long snils, String name, String surname, String patronymic, Date birthDate) {
        this.snils = snils;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDate = birthDate;

    }

    public Long getSnils() {
        return snils;
    }

    public void setSnils(Long Snils) {
        this.snils = Snils;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getMedicalInstitutionCode() {
        return medicalInstitutionCode;
    }

    public void setMedicalInstitutionCode(Integer medicalInstitutionCode) {
        this.medicalInstitutionCode = medicalInstitutionCode;
    }
}

