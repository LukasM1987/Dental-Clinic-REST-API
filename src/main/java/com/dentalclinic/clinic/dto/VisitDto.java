package com.dentalclinic.clinic.dto;

import com.dentalclinic.clinic.domain.Doctor;
import com.dentalclinic.clinic.domain.Patient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VisitDto {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("hour")
    private LocalTime hour;

    @JsonProperty("visitDay")
    private LocalDate visitDay;

    @JsonProperty("patient")
    private PatientDto patient;

    @JsonProperty("doctor")
    private DoctorDto doctor;
}
