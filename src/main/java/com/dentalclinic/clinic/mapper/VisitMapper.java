package com.dentalclinic.clinic.mapper;

import com.dentalclinic.clinic.domain.Visit;
import com.dentalclinic.clinic.dto.DoctorDto;
import com.dentalclinic.clinic.dto.PatientDto;
import com.dentalclinic.clinic.dto.VisitDto;
import com.dentalclinic.clinic.service.DoctorService;
import com.dentalclinic.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitMapper {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    public Visit mapToVisit(final VisitDto visitDto) {
        Visit visit = new Visit(visitDto.getId(), visitDto.getHour(), visitDto.getVisitDay());
        visit.setDoctor(doctorService.getDoctor(visitDto.getDoctorId()));
        visit.setPatient(patientService.getPatient(visitDto.getPatientId()));
        return visit;
    }

    public VisitDto mapToVisitDto(final Visit visit) {
        return new VisitDto(visit.getId(),
                visit.getHour(),
                visit.getVisitDay(),
                visit.getPatient().getId(),
                visit.getDoctor().getId());
    }
}
