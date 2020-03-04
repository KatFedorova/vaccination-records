package ru.fedorova.vaccination.model.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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

