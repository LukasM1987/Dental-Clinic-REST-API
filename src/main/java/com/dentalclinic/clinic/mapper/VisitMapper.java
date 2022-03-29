package com.dentalclinic.clinic.mapper;

import com.dentalclinic.clinic.domain.Visit;
import com.dentalclinic.clinic.dto.DoctorDto;
import com.dentalclinic.clinic.dto.PatientDto;
import com.dentalclinic.clinic.dto.VisitDto;
import org.springframework.stereotype.Service;

@Service
public class VisitMapper {

    public VisitDto mapToVisitDto(final Visit visit, DoctorDto doctor, PatientDto patient) {
        return new VisitDto(visit.getId(),
                visit.getHour(),
                visit.getVisitDay(),
                patient, doctor);
    }
}
