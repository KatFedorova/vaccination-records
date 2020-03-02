package ru.fedorova.vaccination.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medical_worker")
public class MedicalWorker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "medical_worker_id")
    private Integer medicalWorkerId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "position")
    private String position;
    @Column(name = "medical_institution_code")
    private Integer medicalInstitutionCode;

    public MedicalWorker() {
    }

    public MedicalWorker(String name, String surname, String patronymic, String position) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.position = position;
    }

    public MedicalWorker(String name, String surname, String patronymic, String position, Integer medicalInstitutionCode) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.position = position;
        this.medicalInstitutionCode = medicalInstitutionCode;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getMedicalInstitutionCode() {
        return medicalInstitutionCode;
    }

    public void setMedicalInstitutionCode(Integer medicalInstitutionCode) {
        this.medicalInstitutionCode = medicalInstitutionCode;
    }
}