package com.dentalclinic.clinic.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

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
    @Column(name = "VISIT_HOUR")
    private LocalTime hour;

    @NotNull
    @Column(name = "VISIT_DAY")
    private LocalDate visitDay;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;

    public Visit(LocalTime visitHour, LocalDate visitDay) {
        this.hour = visitHour;
        this.visitDay = visitDay;
    }
}
