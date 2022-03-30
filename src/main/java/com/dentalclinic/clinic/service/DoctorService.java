package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.domain.Doctor;
import com.dentalclinic.clinic.repositiory.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctor(Long id) {
        return doctorRepository.findDoctorById(id);
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getDoctorBySurname(String surname) {
        return doctorRepository.findBySurname(surname);
    }

    public List<Doctor> getDoctorBySpecialisation(String specialisation) {
        return doctorRepository.findBySpecialisation(specialisation);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
