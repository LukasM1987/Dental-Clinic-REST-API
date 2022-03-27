package com.dentalclinic.clinic.mapper;

import com.dentalclinic.clinic.domain.Visit;
import com.dentalclinic.clinic.domain.VisitDto;
import org.springframework.stereotype.Service;

@Service
public class VisitMapper {

    public Visit mapToVisit(final VisitDto visitDto) {
        return new Visit(visitDto.getId(),
                visitDto.getHour(),
                visitDto.getVisitDay(),
                visitDto.getPatient(),
                visitDto.getDoctor());
    }

    public Visit mapToVisitDto(final Visit visit) {
        return new Visit(visit.getId(),
                visit.getHour(),
                visit.getVisitDay(),
                visit.getPatient(),
                visit.getDoctor());
    }
}
