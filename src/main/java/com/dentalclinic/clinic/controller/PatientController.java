package com.dentalclinic.clinic.controller;

import com.dentalclinic.clinic.domain.Patient;
import com.dentalclinic.clinic.dto.PatientDto;
import com.dentalclinic.clinic.exceptions.PatientException;
import com.dentalclinic.clinic.mapper.PatientMapper;
import com.dentalclinic.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientMapper patientMapper;
    private final PatientService patientService;

    @RequestMapping(method = RequestMethod.POST, value = "addPatient", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPatient(@RequestBody final PatientDto patientDto) {
        Patient patient = patientMapper.mapToPatient(patientDto);
        patientService.addPatient(patient);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getPatient")
    public PatientDto getPatientById(final Long id) throws PatientException {
        return patientMapper.mapToPatientDto(patientService.getPatient(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deletePatient")
    public void deletePatient(final Long id) {
        patientService.deletePatient(id);
    }
}
