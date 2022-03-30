package com.dentalclinic.clinic.repositiory;

import com.dentalclinic.clinic.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PatientRepository extends CrudRepository<Patient, Long> {

    List<Patient> findBySurname(String surname);
    Patient findPatientById(Long id);

}
