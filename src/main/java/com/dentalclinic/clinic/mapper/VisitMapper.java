package com.dentalclinic.clinic.mapper;

import com.dentalclinic.clinic.domain.Visit;
import com.dentalclinic.clinic.dto.VisitDto;
import org.springframework.stereotype.Service;

@Service
public class VisitMapper {

    public VisitDto mapToVisitDto(final Visit visit, Long doctorId, Long patientId) {
        return new VisitDto(visit.getId(),
                visit.getHour(),
                visit.getVisitDay(),
                doctorId, patientId);
    }
}
