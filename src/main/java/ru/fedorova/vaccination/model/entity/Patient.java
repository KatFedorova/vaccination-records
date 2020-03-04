package ru.fedorova.vaccination.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

