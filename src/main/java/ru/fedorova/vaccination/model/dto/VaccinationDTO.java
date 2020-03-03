package ru.fedorova.vaccination.model.dto;


import org.springframework.format.annotation.DateTimeFormat;
import ru.fedorova.vaccination.service.Snils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;


public class VaccinationDTO implements Serializable {
    @NotNull
    @NotBlank
    @Size (min = 11, max = 11, message = "Введите 11 знаков")
    @Pattern(regexp = "^[0-9]+", message = "Введите цифры")
    @Snils(message = "Проверьте контрольную сумму СНИЛС")
    private String snils;
    @NotNull
    private Boolean consent;
    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private String date;
    @NotNull
    @Pattern(regexp = "^[0-9]+", message = "Введите цифры")
    private String drugId;
    @NotNull
    @Pattern(regexp = "^[0-9]+", message = "Введите цифры")
    private String medicalWorkerId;
    private String medicalInstitutionCode;

    public VaccinationDTO() {
    }

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
