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

    @OneToMany(targetEntity = Visit.class, mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Visit> visits = new ArrayList<>();

}
