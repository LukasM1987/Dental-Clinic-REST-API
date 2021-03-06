package com.dentalclinic.clinic.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PATIENTS")
public class Patient {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PATIENT_ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @OneToMany(targetEntity = Visit.class, mappedBy = "patient", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Visit> visits;

    public Patient(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.visits = new ArrayList<Visit>();
    }

    public Patient(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.visits = new ArrayList<Visit>();
    }
}
