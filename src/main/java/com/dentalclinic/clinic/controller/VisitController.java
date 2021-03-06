package com.dentalclinic.clinic.controller;


import com.dentalclinic.clinic.domain.Doctor;
import com.dentalclinic.clinic.domain.Visit;
import com.dentalclinic.clinic.dto.VisitDto;
import com.dentalclinic.clinic.mapper.DoctorMapper;
import com.dentalclinic.clinic.mapper.PatientMapper;
import com.dentalclinic.clinic.mapper.VisitMapper;
import com.dentalclinic.clinic.service.DoctorService;
import com.dentalclinic.clinic.service.PatientService;
import com.dentalclinic.clinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public VisitDto getVisit(@RequestParam final Long id, @RequestParam final Long doctorId, @RequestParam final Long patientId) {
        return visitMapper.mapToVisitDto(visitService.getVisit(id), doctorMapper.mapToDoctorDto(doctorService.getDoctor(doctorId)), patientMapper.mapToPatientDto(patientService.getPatient(patientId)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createVisit")
    public VisitDto createVisit(@RequestParam final Long doctorId, @RequestParam final Long patientId) {
        Visit visit = visitService.createVisit(doctorId, patientId);
        return visitMapper.mapToVisitDto(visit, doctorMapper.mapToDoctorDto(doctorService.getDoctor(doctorId)), patientMapper.mapToPatientDto(patientService.getPatient(patientId)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteVisit")
    public void deleteVisit(final Long id) {
        visitService.deleteVisitById(id);
    }
}
