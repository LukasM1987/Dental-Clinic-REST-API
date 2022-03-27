package com.dentalclinic.clinic.repositiory;

import com.dentalclinic.clinic.domain.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
@Transactional
public interface VisitRepository extends CrudRepository<Visit, Long> {

    Visit findVisitByVisitDay(LocalDate visitDay);

    Visit findVisitByHour(LocalTime hour);
}
