package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.domain.Doctor;
import com.dentalclinic.clinic.domain.Patient;
import com.dentalclinic.clinic.domain.Visit;
import com.dentalclinic.clinic.repositiory.DoctorRepository;
import com.dentalclinic.clinic.repositiory.PatientRepository;
import com.dentalclinic.clinic.repositiory.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public Visit findVisitByDate(final Visit visit) {
        return visitRepository.findVisitByVisitDay(visit.getVisitDay());
    }

    public Visit findVisitByHour(final Visit visit) {
        return visitRepository.findVisitByHour(visit.getHour());
    }

    public Visit createVisit(final Long doctorId, final Long patientId) {
        Doctor doctor = doctorRepository.findDoctorById(doctorId);
        Patient patient = patientRepository.findPatientById(patientId);
        Visit visit = new Visit();
        visit.setHour(LocalTime.now());
        visit.setVisitDay(LocalDate.now());
        visit.setDoctor(doctor);
        visit.setPatient(patient);
        return visitRepository.save(visit);
    }

    public void deleteVisitById(final Long id) {
        visitRepository.deleteById(id);
    }

    public Visit getVisit(Long id) {
        return visitRepository.findVisitById(id);
    }
}
