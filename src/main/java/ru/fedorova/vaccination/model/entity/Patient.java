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
    private Integer patient_id;
    @Column(name = "SNILS")
    private Long SNILS;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birthDate")
    private Date birthDate;
    @Column(name = "medical_institution_code")
    private Integer medical_institution_code;

    public Patient() {
    }

    public Patient(Long SNILS, String name, String surname, String patronymic, Date birthDate, Integer medical_institution_code) {
        this.SNILS = SNILS;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.medical_institution_code = medical_institution_code;
    }

    public Long getSNILS() {
        return SNILS;
    }

    public void setSNILS(Long SNILS) {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getMedical_institution_code() {
        return medical_institution_code;
    }

    public void setMedical_institution_code(Integer medical_institution_code) {
        this.medical_institution_code = medical_institution_code;
    }
}

