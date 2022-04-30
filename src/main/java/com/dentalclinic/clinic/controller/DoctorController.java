package com.dentalclinic.clinic.controller;

import com.dentalclinic.clinic.domain.Doctor;
import com.dentalclinic.clinic.dto.DoctorDto;
import com.dentalclinic.clinic.exceptions.DoctorException;
import com.dentalclinic.clinic.mapper.DoctorMapper;
import com.dentalclinic.clinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getAllDoctors")
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return doctorMapper.mapToDoctorDtoList(doctors);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addDoctor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addDoctor(@RequestBody final DoctorDto doctorDto) {
        Doctor doctor = doctorMapper.mapToDoctor(doctorDto);
        doctorService.addDoctor(doctor);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getDoctor")
    public DoctorDto getDoctorById(final Long id) {
        return doctorMapper.mapToDoctorDto(doctorService.getDoctor(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getDoctorBySurname")
    public List<DoctorDto> getDoctorBySurname(@RequestParam String surname) {
        List<Doctor> doctors = doctorService.getDoctorBySurname(surname);
        return doctorMapper.mapToDoctorDtoList(doctors);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getDoctorBySpecialisation")
    public List<DoctorDto> getDoctorBySpecialisation(@RequestParam String specialisation) {
        List<Doctor> doctors = doctorService.getDoctorBySpecialisation(specialisation);
        return doctorMapper.mapToDoctorDtoList(doctors);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteDoctor")
    public void deleteDoctor(final Long id) {
        doctorService.deleteDoctor(id);
    }
}
