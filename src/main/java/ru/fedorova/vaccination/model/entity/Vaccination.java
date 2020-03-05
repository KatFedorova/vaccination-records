package ru.fedorova.vaccination.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "vaccination", schema = "vaccination")
public class Vaccination implements Serializable {
    @Column(name = "vaccination_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer vaccinationId;

    @NonNull
    @Column(name = "SNILS")
    private Long snils;

    @NonNull
    @Column(name = "consent")
    private Boolean consent;

    @NonNull
    @Column(name = "vac_date")
    private Date date;

    @NonNull
    @Column(name = "drug_id")
    private Integer drugId;

    @NonNull
    @Column(name = "medical_worker_id")
    private Integer medicalWorkerId;

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
