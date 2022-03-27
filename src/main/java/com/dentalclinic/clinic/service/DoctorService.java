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

    public Optional<Doctor> getDoctor(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctorBySurname(Doctor doctor) {
        return doctorRepository.findBySurname(doctor.getSurname());
    }

    public Doctor getDoctorBySpecialisation(Doctor doctor) {
        return doctorRepository.findBySpecialisation(doctor.getSpecialisation());
    }
}
