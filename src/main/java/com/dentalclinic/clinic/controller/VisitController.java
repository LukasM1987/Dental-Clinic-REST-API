package com.dentalclinic.clinic.controller;


import com.dentalclinic.clinic.domain.Doctor;
import com.dentalclinic.clinic.domain.Visit;
import com.dentalclinic.clinic.dto.VisitDto;
import com.dentalclinic.clinic.exceptions.VisitException;
import com.dentalclinic.clinic.mapper.DoctorMapper;
import com.dentalclinic.clinic.mapper.PatientMapper;
import com.dentalclinic.clinic.mapper.VisitMapper;
import com.dentalclinic.clinic.service.DoctorService;
import com.dentalclinic.clinic.service.PatientService;
import com.dentalclinic.clinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/visits")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    private final VisitMapper visitMapper;
    private final DoctorMapper doctorMapper;
    private final PatientMapper patientMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getVisit")
    public VisitDto getVisit(@RequestParam final Long id) throws VisitException {
        return visitMapper.mapToVisitDto(visitService.getVisit(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createVisit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createVisit(@RequestBody final VisitDto visitDto) {
        Visit visit = visitMapper.mapToVisit(visitDto);
        visitService.createVisit(visit);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteVisit")
    public void deleteVisit(final Long id) throws VisitException {
        visitService.deleteVisitById(id);
    }
}
