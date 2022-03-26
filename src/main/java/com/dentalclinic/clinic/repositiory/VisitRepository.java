package com.dentalclinic.clinic.repositiory;

import com.dentalclinic.clinic.domain.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
@Transactional
public interface VisitRepository extends CrudRepository<Visit, Long> {

    Visit findByDate(Date visitDate);
}
