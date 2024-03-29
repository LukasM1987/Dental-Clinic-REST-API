package com.dentalclinic.clinic.repositiory;

import com.dentalclinic.clinic.domain.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
@Transactional
public interface VisitRepository extends CrudRepository<Visit, Long> {

    @Override
    Optional<Visit> findById(Long aLong);

    Optional<Visit> findVisitByVisitDay(LocalDate visitDay);

    Optional<Visit> findVisitByHour(LocalTime hour);

}
