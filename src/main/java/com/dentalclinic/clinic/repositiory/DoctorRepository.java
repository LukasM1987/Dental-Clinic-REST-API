package com.dentalclinic.clinic.repositiory;

import com.dentalclinic.clinic.domain.Doctor;
import com.dentalclinic.clinic.domain.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    List<Doctor> findAll();

    Doctor findBySurname(String surname);
    Doctor findBySpecialisation(String specialisation);

}
