package com.dentalclinic.clinic.dto;

import com.dentalclinic.clinic.domain.Doctor;
import com.dentalclinic.clinic.domain.Patient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VisitDto {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("hour")
    private LocalTime hour;

    @JsonProperty("visitDay")
    private LocalDate visitDay;

    @JsonProperty("patientId")
    private Long patientId;

    @JsonProperty("doctor")
    private Long doctorId;
}
