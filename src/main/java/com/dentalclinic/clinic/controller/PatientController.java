package com.dentalclinic.clinic.controller;

import com.dentalclinic.clinic.domain.Doctor;
import com.dentalclinic.clinic.domain.Patient;
import com.dentalclinic.clinic.dto.DoctorDto;
import com.dentalclinic.clinic.dto.PatientDto;
import com.dentalclinic.clinic.exceptions.PatientException;
import com.dentalclinic.clinic.mapper.PatientMapper;
import com.dentalclinic.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public PatientDto getPatientById(final Long id) {
        return patientMapper.mapToPatientDto(patientService.getPatient(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getPatientBySurname")
    public List<PatientDto> getDoctorBySurname(@RequestParam String surname) {
        List<Patient> patients = patientService.getPatientBySurname(surname);
        return patientMapper.mapToPatientDtoList(patients);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deletePatient")
    public void deletePatient(final Long id) {
        patientService.deletePatient(id);
    }
}
