package com.Hospital.Management.System.service;

import com.Hospital.Management.System.dto.AppointmentDto;

import java.util.List;

public interface AppointmentRepoService {
    AppointmentDto createAppointment(AppointmentDto dto);
    List<AppointmentDto> getAllAppointment();
    AppointmentDto getAppointmentById(Long id);
    AppointmentDto updateAppointment(Long id, AppointmentDto dto);
    String deleteAppointment(Long id);
}
