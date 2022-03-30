package com.dentalclinic.clinic.mapper;

import com.dentalclinic.clinic.domain.Patient;
import com.dentalclinic.clinic.dto.PatientDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<PatientDto> mapToPatientDtoList(final List<Patient> patients) {
        return patients.stream().map(this::mapToPatientDto).collect(Collectors.toList());
    }
}
