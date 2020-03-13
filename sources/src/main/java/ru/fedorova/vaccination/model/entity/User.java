package ru.fedorova.vaccination.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Класс описывает модель Пользователя из таблицы user БД
 * userId генерируется автоматически, соответствует полю user_id в БД
 * строковые поля name, password, role соответствуют одноименным полям в БД
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
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "password")
    private String password;

    @Column(name = "medical_worker_id")
    private Integer medicalWorkerId;

    @Column(name = "role")
    private String role;
}