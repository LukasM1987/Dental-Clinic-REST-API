package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.domain.Patient;
import com.dentalclinic.clinic.repositiory.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient getPatient(Long id) {
        return patientRepository.findPatientById(id);
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient getPatientBySurname(Patient patient) {
        return patientRepository.findBySurname(patient.getSurname());
    }
}
