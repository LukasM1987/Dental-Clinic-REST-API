package com.dentalclinic.clinic.repositiory;

import com.dentalclinic.clinic.domain.Doctor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DoctorRepository {

    List<Doctor> findAll();

    Doctor findBySurname(String surname);
    Doctor findBySpecialisation(String specialisation);

}
