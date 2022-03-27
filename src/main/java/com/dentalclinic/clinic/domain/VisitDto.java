package com.dentalclinic.clinic.domain;

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

    @JsonProperty("VISIT_HOUR")
    private LocalTime hour;

    @JsonProperty("VISIT_DAY")
    private LocalDate visitDay;

    @JsonProperty("PATIENT")
    private Patient patient;

    @JsonProperty("DOCTOR")
    private Doctor doctor;
}
