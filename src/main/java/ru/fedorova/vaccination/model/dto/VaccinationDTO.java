package ru.fedorova.vaccination.model.dto;


import java.io.Serializable;


public class VaccinationDTO implements Serializable {

    private String SNILS;
    private Boolean consent;
    private String date;
    private String drugId;
    private String medicalWorkerId;
    private String medical_institution_code;

    public VaccinationDTO(String SNILS, Boolean consent, String date, String drugId, String medicalWorkerId) {
        this.consent = consent;
        this.date = date;
        this.SNILS = SNILS;
        this.drugId = drugId;
        this.medicalWorkerId = medicalWorkerId;

    }

    public String getSNILS() {
        return SNILS;
    }

    public void setSNILS(String SNILS) {
        this.SNILS = SNILS;
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

    public String getMedical_institution_code() {
        return medical_institution_code;
    }

    public void setMedical_institution_code(String medical_institution_code) {
        this.medical_institution_code = medical_institution_code;
    }

    @Override
    public String toString() {
        String consentToStr = (consent) ? "да" : "нет";
        return "Прививка: " +
                "согласие - " + consentToStr +
                ", дата: " + date +
                ", СНИЛС: " + SNILS +
                ", препарат: " + drugId +
                ", работник: " + medicalWorkerId;
    }

}
