package com.dentalclinic.clinic.mapper;

import com.dentalclinic.clinic.domain.Doctor;
import com.dentalclinic.clinic.dto.DoctorDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorMapper {

    public Doctor mapToDoctor(final DoctorDto doctorDto) {
        return new Doctor(doctorDto.getId(),
                doctorDto.getName(),
                doctorDto.getSurname(),
                doctorDto.getSpecialisation());
    }

    public DoctorDto mapToDoctorDto(final Doctor doctor) {
        return new DoctorDto(doctor.getId(),
                doctor.getName(),
                doctor.getSurname(),
                doctor.getSpecialisation());
    }

    public List<DoctorDto> mapToDoctorDtoList(final List<Doctor> doctors) {
        return doctors.stream().map(this::mapToDoctorDto).collect(Collectors.toList());
    }
}
