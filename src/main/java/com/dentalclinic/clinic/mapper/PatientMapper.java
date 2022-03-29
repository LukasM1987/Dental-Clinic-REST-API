package com.dentalclinic.clinic.mapper;

import com.dentalclinic.clinic.domain.Patient;
import com.dentalclinic.clinic.dto.PatientDto;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    public Patient mapToPatient(final PatientDto patientDto) {
        return new Patient(patientDto.getId(),
                patientDto.getName(),
                patientDto.getSurname());
    }

    public PatientDto mapToPatientDto(final Patient patient) {
        return new PatientDto(patient.getId(),
                patient.getName(),
                patient.getSurname());
    }
}
