package ru.fedorova.vaccination.model.dto;

public class MedicalWorkerDTO {
    private String name;
    private String surname;
    private String patronymic;
    private String position;
    private String medicalInstitutionCode;

    public MedicalWorkerDTO(String name, String surname, String patronymic, String position, String medicalInstitutionCode) {
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

    public String getMedicalInstitutionCode() {
        return medicalInstitutionCode;
    }

    public void setMedicalInstitutionCode(String medicalInstitutionCode) {
        this.medicalInstitutionCode = medicalInstitutionCode;
    }
}
