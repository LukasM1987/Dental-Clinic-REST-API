package com.dentalclinic.clinic.repositiory;

import com.dentalclinic.clinic.domain.Patient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PatientRepository {

    Patient findBySurname(String surname);

}
