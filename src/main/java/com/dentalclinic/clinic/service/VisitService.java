package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.domain.Visit;
import com.dentalclinic.clinic.repositiory.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

    public Visit findVisitByDate(Visit visit) {
        return visitRepository.findVisitByVisitDay(visit.getVisitDay());
    }

    public Visit findVisitByHour(Visit visit) {
        return visitRepository.findVisitByHour(visit.getHour());
    }
}
