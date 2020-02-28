package ru.fedorova.vaccination.model.entity;


import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table (name = "drug")
public class Drug implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "drug_id")
    private Integer drugId;
    @Column(name = "name")
    private String name;
    @Column(name = "MNN")
    private String MNN;

    public Drug() {
    }

    public Drug(String name, String MNN) {
        this.name = name;
        this.MNN = MNN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMNN() {
        return MNN;
    }

    public void setMNN(String MNN) {
        this.MNN = MNN;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "name='" + name + '\'' +
                ", MNN='" + MNN + '\'' +
                '}';
    }
}

