package ru.fedorova.vaccination.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * Класс описывает модель Прививки из таблицы vaccination БД
 * vaccinationId генерируется автоматически, соответствует полю vaccination_id в БД
 * числовое поле snils соответсвует полю SNILS в БД
 * булево поле consent соответсвует полю consent в БД
 * поле date является датой и соответсвует полю vac_date в БД
 * числовое поле drugId соответсвует полю drug_id в БД
 * целочисленное поле medicalWorkerId соответствует medical_worker_id в БД
 * <p>
 * Аннотация @Data генерирует геттеры и сеттеры для всех полей, кроме id,
 * а также создаёт конструктор для полей с аннотацией @NonNull
 * <p>
 * Аннотация @NoArgsConstructor создаёт конструктор без параметров
 */
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
