package com.dentalclinic.clinic.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VisitDto {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("HOUR")
    private LocalTime hour;

    @JsonProperty("VISIT_DAY")
    private Date visitDay;
}
