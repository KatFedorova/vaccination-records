package ru.fedorova.vaccination.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "vaccination", schema = "vaccination")
public class Vaccination implements Serializable {
    @Column(name = "vaccination_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer vaccinationId;
    @Column(name = "SNILS")
    private Long snils;
    @Column(name = "consent")
    private Boolean consent;
    @Column(name = "vac_date")
    private Date date;
    @Column(name = "drug_id")
    private Integer drugId;
    @Column(name = "medical_worker_id")
    private Integer medicalWorkerId;


    public Vaccination() {
    }
    public Vaccination(Long snils, Boolean consent, Date date, Integer drugId, Integer medicalWorkerId) {
        this.snils = snils;
        this.consent = consent;
        this.date = date;
        this.drugId = drugId;
        this.medicalWorkerId = medicalWorkerId;

    }




    public Long getSnils() {
        return snils;
    }

    public void setSnils(Long SNILS) {
        this.snils = SNILS;
    }

    public Boolean getConsent() {
        return consent;
    }

    public void setConsent(Boolean consent) {
        this.consent = consent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Integer getMedicalWorkerId() {
        return medicalWorkerId;
    }

    public void setMedicalWorkerId(Integer medicalWorkerId) {
        this.medicalWorkerId = medicalWorkerId;
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
