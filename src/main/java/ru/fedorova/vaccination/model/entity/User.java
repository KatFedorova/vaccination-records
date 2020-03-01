package ru.fedorova.vaccination.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "medical_worker_id")
    private Integer medicalWorkerId;
    @Column(name = "role")
    private String role;


    public User(String name, String password, Integer medicalWorkerId, String role) {
        this.name = name;
        this.password = password;
        this.medicalWorkerId = medicalWorkerId;
        this.role = role;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMedicalWorkerId() {
        return medicalWorkerId;
    }

    public void setMedicalWorkerId(Integer medicalWorkerId) {
        this.medicalWorkerId = medicalWorkerId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Пользователь{" +
                "имя='" + name + '\'' +
                ", пароль='" + '\'' +
                '}';
    }
}