package ru.fedorova.vaccination.model.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Класс описывает модель Препарата из таблицы drug БД
 * drugId генерируется автоматически, соответствует полю drug_id в БД
 * строковое поле name является торговым наименованием препарата, соответствует полю name в БД
 * строковое поле MNN является непатентованным наименованием препарата, соответствует полю MNN в БД
 * <p>
 * Аннотация @Data генерирует геттеры и сеттеры для всех полей, кроме id,
 * а также создаёт конструктор для полей с аннотацией @NonNull
 * <p>
 * Аннотация @NoArgsConstructor создаёт конструктор без параметров
 */

@Entity
@Data
@NoArgsConstructor
@Table (name = "drug")
public class Drug implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "drug_id")
    private Integer drugId;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "MNN")
    private String MNN;

}

