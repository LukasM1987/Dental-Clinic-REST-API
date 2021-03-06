package com.dentalclinic.clinic.domain;


import com.dentalclinic.clinic.repositiory.PatientRepository;
import com.dentalclinic.clinic.repositiory.VisitRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientTestSuite {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private VisitRepository visitRepository;

    @Test
    public void addPatientTest() {
        //Given
        Patient patient = new Patient("Lukasz", "Marchel");

        //When
        patientRepository.save(patient);
        Long id = patient.getId();
        Optional<Patient> testPatient = patientRepository.findById(id);

        //Then
        assertTrue(testPatient.isPresent());
        assertNotNull(id);

        //Clean Up
        try {
            patientRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addPatientWithVisitTest() {
        //Given
        Patient patient = new Patient("Lukasz", "Marchel");
        Visit visit = new Visit(LocalTime.now(), LocalDate.now());
        patient.getVisits().add(visit);

        //When
        patientRepository.save(patient);
        Long patientId = patient.getId();
        Long visitId = visit.getId();

        //Then
        assertNotNull(patientId);
        assertNotNull(visitId);

        //Clean Up
        try {
            patientRepository.deleteById(patientId);
            visitRepository.deleteById(visitId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deletePatientTest() {
        //Given
        Patient patient = new Patient("Lukasz", "Marchel");
        patientRepository.save(patient);

        //When
        Long patientId = patient.getId();
        patientRepository.deleteById(patientId);

        //Then
        assertFalse(patientRepository.existsById(patientId));
    }

    @Test
    public void findPatientBySurnameTest() {
        //Given
        Patient patient = new Patient("Lukasz", "Marchel");

        //When
        patientRepository.save(patient);
        Long id = patient.getId();
        List<Patient> patientSurname = patientRepository.findBySurname(patient.getSurname());

        //Then
        assertNotNull(patientSurname);
        assertEquals("Marchel", patientSurname.get(0).getSurname());

        //Clean Up
        try {
            patientRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
