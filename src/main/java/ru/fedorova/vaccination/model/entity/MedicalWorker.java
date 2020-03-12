package ru.fedorova.vaccination.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Класс описывает модель Медицинского работника из таблицы medical_worker в БД
 * drugId генерируется автоматически, соответствует полю drug_id в БД
 * строковые поля name, surname, patronymic, position соответствуют одноименным полям в БД
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
@Table(name = "medical_worker")
public class MedicalWorker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "medical_worker_id")
    private Integer medicalWorkerId;

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
    @Column(name = "position")
    private String position;

    @NonNull
    @Column(name = "medical_institution_code")
    private Integer medicalInstitutionCode;


}