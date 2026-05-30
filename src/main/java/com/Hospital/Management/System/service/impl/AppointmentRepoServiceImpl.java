package com.Hospital.Management.System.service.impl;

import com.Hospital.Management.System.dto.AppointmentDto;
import com.Hospital.Management.System.entity.Appointment;
import com.Hospital.Management.System.exception.ResourceNotFoundException;
import com.Hospital.Management.System.repository.AppointmentRepository;
import com.Hospital.Management.System.service.AppointmentRepoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentRepoServiceImpl implements AppointmentRepoService {
    private final AppointmentRepository appointmentRepository;
    public AppointmentRepoServiceImpl(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentDto createAppointment(AppointmentDto dto) {
        Appointment appointment = new Appointment();
        appointment.setName(dto.getName());
        appointment.setAge(dto.getAge());
        appointment.setSymptoms(dto.getSymptoms());
        appointment.setNumber(dto.getNumber());

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return mapToDto(savedAppointment);
    }

    @Override
    public List<AppointmentDto> getAllAppointment() {
        return appointmentRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDto getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No record found"));
        return mapToDto(appointment);

    }

    @Override
    public AppointmentDto updateAppointment(Long id, AppointmentDto dto) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No record found"));
        appointment.setName(dto.getName());
        appointment.setAge(dto.getAge());
        appointment.setSymptoms(dto.getSymptoms());
        appointment.setNumber(dto.getNumber());

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return mapToDto(savedAppointment);
    }

    @Override
    public String deleteAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No record found"));
        appointmentRepository.delete(appointment);
        return "Record deleted";
    }


    private AppointmentDto mapToDto(Appointment dto){
        return new AppointmentDto(
                dto.getName(),
                dto.getAge(),
                dto.getSymptoms(),
                dto.getNumber()
        );
    }
}
