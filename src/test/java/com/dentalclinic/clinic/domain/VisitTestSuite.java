package com.dentalclinic.clinic.domain;

import com.dentalclinic.clinic.exceptions.VisitException;
import com.dentalclinic.clinic.repositiory.VisitRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitTestSuite {

    @Autowired
    private VisitRepository visitRepository;

    @Test
    public void addVisitTest() {
        //Given
        Visit visit = new Visit(LocalTime.now(), LocalDate.now());

        //When
        visitRepository.save(visit);
        Long id = visit.getId();
        Optional<Visit> testVisit = visitRepository.findById(id);

        //Then
        assertTrue(testVisit.isPresent());
        assertNotNull(id);

        //Clean Up
        try {
            visitRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findVisitByDateTest() throws VisitException {
        //Given
        LocalDate day = LocalDate.of(2022, 03, 27);
        Visit visit = new Visit(LocalTime.now(), day);

        //When
        visitRepository.save(visit);
        Long id = visit.getId();
        Visit visitDay = visitRepository.findVisitByVisitDay(day).orElseThrow(VisitException::new);

        //Then
        assertNotNull(visitDay);
        assertEquals(day, visitDay.getVisitDay());

        //Clean Up
        try {
            visitRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
