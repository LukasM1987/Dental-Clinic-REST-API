package com.dentalclinic.clinic.repositiory;

import com.dentalclinic.clinic.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    List<Doctor> findAll();

    Doctor findBySurname(String surname);
    Doctor findBySpecialisation(String specialisation);
    Doctor findDoctorById(Long id);

}
