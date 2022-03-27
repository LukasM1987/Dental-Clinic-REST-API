package com.dentalclinic.clinic.domain;


import com.dentalclinic.clinic.repositiory.DoctorRepository;
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
public class DoctorTestSuite {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private VisitRepository visitRepository;

    @Test
    public void addDoctorTest() {
        //Given
        Doctor doctor = new Doctor("Lukasz", "Marchel", "Surgery");

        //When
        doctorRepository.save(doctor);
        Long id = doctor.getId();
        Optional<Doctor> testDoctor = doctorRepository.findById(id);

        //Then
        assertTrue(testDoctor.isPresent());
        assertNotNull(id);

        //Clean Up
        try {
            doctorRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addDoctorWithVisitTest() {
        //Given
        Doctor doctor = new Doctor("Lukasz", "Marchel", "Surgery");
        Visit visit = new Visit(LocalTime.now(), LocalDate.now());
        doctor.getVisits().add(visit);

        //When
        doctorRepository.save(doctor);
        Long doctorId = doctor.getId();
        Long visitId = visit.getId();

        //Then
        assertNotNull(doctorId);
        assertNotNull(visitId);

        //Clean Up
        try {
            doctorRepository.deleteById(doctorId);
            visitRepository.deleteById(visitId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteDoctorTest() {
        //Given
        Doctor doctor = new Doctor("Lukasz", "Marchel", "Surgery");
        doctorRepository.save(doctor);

        //When
        Long doctorId = doctor.getId();
        doctorRepository.deleteById(doctorId);

        //Then
        assertFalse(doctorRepository.existsById(doctorId));
    }

    @Test
    public void findDoctorBySurnameTest() {
        //Given
        Doctor doctor = new Doctor("Lukasz", "Marchel", "Surgery");

        //When
        doctorRepository.save(doctor);
        Long id = doctor.getId();
        Doctor doctorSurname = doctorRepository.findBySurname(doctor.getSurname());

        //Then
        assertNotNull(doctorSurname);
        assertEquals("Marchel", doctorSurname.getSurname());

        //Clean Up
        try {
            doctorRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findDoctorBySpecialisationTest() {
        //Given
        Doctor doctor = new Doctor("Lukasz", "Marchel", "Surgery");

        //When
        doctorRepository.save(doctor);
        Long id = doctor.getId();
        Doctor doctorSpecialisation = doctorRepository.findBySpecialisation(doctor.getSpecialisation());

        //Then
        assertNotNull(doctorSpecialisation);
        assertEquals("Surgery", doctorSpecialisation.getSpecialisation());

        //Clean Up
        try {
            doctorRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAllDoctorsTest() {
        //Given
        Doctor doctor1 = new Doctor("Lukasz", "Marchel", "Surgery");
        Doctor doctor2 = new Doctor("Aleksandra", "Kierzkiewicz", "Orthodontist");
        doctorRepository.save(doctor1);
        doctorRepository.save(doctor2);
        Long doctor1Id = doctor1.getId();
        Long doctor2Id = doctor2.getId();

        //When
        List<Doctor> doctors = doctorRepository.findAll();

        //Then
        assertEquals(2, doctors.size());

        //Clean
        try {
            doctorRepository.deleteById(doctor1Id);
            doctorRepository.deleteById(doctor2Id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
