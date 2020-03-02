package ru.fedorova.vaccination.model.dto;


import java.io.Serializable;


public class VaccinationDTO implements Serializable {

    private String snils;
    private Boolean consent;
    private String date;
    private String drugId;
    private String medicalWorkerId;
    private String medicalInstitutionCode;

    public VaccinationDTO(String snils, Boolean consent, String date, String drugId, String medicalWorkerId) {
        this.consent = consent;
        this.date = date;
        this.snils = snils;
        this.drugId = drugId;
        this.medicalWorkerId = medicalWorkerId;

    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public Boolean getConsent() {
        return consent;
    }

    public void setConsent(Boolean consent) {
        this.consent = consent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getMedicalWorkerId() {
        return medicalWorkerId;
    }

    public void setMedicalWorkerId(String medicalWorkerId) {
        this.medicalWorkerId = medicalWorkerId;
    }

    public String getMedicalInstitutionCode() {
        return medicalInstitutionCode;
    }

    public void setMedicalInstitutionCode(String medicalInstitutionCode) {
        this.medicalInstitutionCode = medicalInstitutionCode;
    }

    @Override
    public String toString() {
        String consentToStr = (consent) ? "да" : "нет";
        return "Прививка: " +
                "согласие - " + consentToStr +
                ", дата: " + date +
                ", СНИЛС: " + snils +
                ", препарат: " + drugId +
                ", работник: " + medicalWorkerId;
    }

}
