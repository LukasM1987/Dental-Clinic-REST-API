package com.dentalclinic.clinic.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "VISITATIONS")
public class Visit {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "VISIT_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "HOUR")
    private LocalTime hour;

    @NotNull
    @Column(name = "VISIT_DATE")
    private Date visitDate;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;
}
