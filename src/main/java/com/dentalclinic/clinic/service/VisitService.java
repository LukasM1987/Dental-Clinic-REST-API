package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.domain.Doctor;
import com.dentalclinic.clinic.domain.Patient;
import com.dentalclinic.clinic.domain.Visit;
import com.dentalclinic.clinic.exceptions.VisitException;
import com.dentalclinic.clinic.repositiory.DoctorRepository;
import com.dentalclinic.clinic.repositiory.PatientRepository;
import com.dentalclinic.clinic.repositiory.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class VisitService {


    private VisitRepository visitRepository;
    //private final DoctorRepository doctorRepository;
    //private final PatientRepository patientRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public Visit findVisitByDate(final LocalDate localDate) throws VisitException {
        return visitRepository.findVisitByVisitDay(localDate).orElseThrow(VisitException::new);
    }

    public Visit findVisitByHour(final LocalTime localTime) throws VisitException {
        return visitRepository.findVisitByHour(localTime).orElseThrow(VisitException::new);
    }

    public Visit createVisit(final Visit visit) {
        /*
        Doctor doctor = doctorRepository.findDoctorById(doctorId);
        Patient patient = patientRepository.findPatientById(patientId);
        Visit visit = new Visit();
        visit.setHour(LocalTime.now());
        visit.setVisitDay(LocalDate.now());
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        return visitRepository.save(visit);
        */
        return visitRepository.save(visit);
    }

    public void deleteVisitById(final Long id) throws VisitException {
        if (visitRepository.findById(id).isPresent()) {
            visitRepository.deleteById(id);
        } else {
            throw new VisitException();
        }
    }

    public Visit getVisit(Long id) throws VisitException {
        return visitRepository.findById(id).orElseThrow(VisitException::new);
    }
}
