package ru.fedorova.vaccination.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Класс описывает модель Пациента из таблицы patient в БД
 * patientId генерируется автоматически, соответствует полю patient_id в БД
 * числовое поле snils соответсвует полю SNILS в БД
 * строковые поля name, surname, patronymic, position соответствуют одноименным полям в БД
 * поле birthDate является датой и соответсвует полю birth_date в БД
 * целочисленное поле medicalInstitutionCode соответствует medical_institution_code в БД
 * <p>
 * Аннотация @Data генерирует геттеры и сеттеры для всех полей, кроме id,
 * а также создаёт конструктор для полей с аннотацией @NonNull
 * <p>
 * Аннотация @NoArgsConstructor создаёт конструктор без параметров
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "patient")
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private Integer patientId;

    @NonNull
    @Column(name = "SNILS")
    private Long snils;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "surname")
    private String surname;

    @NonNull
    @Column(name = "patronymic")
    private String patronymic;

    @NonNull
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "medical_institution_code")
    private Integer medicalInstitutionCode;

}

