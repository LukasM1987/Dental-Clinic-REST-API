package com.dentalclinic.clinic.domain;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "DOCTORS")
public class Doctor {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "DOCTOR_ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "SPECIALISATION")
    private String specialisation;

    @OneToMany(targetEntity = Visit.class, mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Visit> visits;

    public Doctor(String name, String surname, String specialisation) {
        this.name = name;
        this.surname = surname;
        this.specialisation = specialisation;
        this.visits = new ArrayList<Visit>();
    }

    public Doctor(Long id, String name, String surname, String specialisation) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.specialisation = specialisation;
        this.visits = new ArrayList<Visit>();
    }
}
