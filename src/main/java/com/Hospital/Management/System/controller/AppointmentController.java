package com.Hospital.Management.System.controller;

import com.Hospital.Management.System.dto.AppointmentDto;
import com.Hospital.Management.System.service.AppointmentRepoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentRepoService appointmentRepoService;

    public AppointmentController(AppointmentRepoService appointmentRepoService) {
        this.appointmentRepoService = appointmentRepoService;
    }

    //create
    @PostMapping
    public AppointmentDto createAppointment(@Valid @RequestBody AppointmentDto dto){
        return appointmentRepoService.createAppointment(dto);
    }

    //read
    @GetMapping("/{id}")
    public AppointmentDto getAppointmentById(@PathVariable Long id){
        return appointmentRepoService.getAppointmentById(id);
    }

    @GetMapping
    public List<AppointmentDto>getAllAppointments(){
        return appointmentRepoService.getAllAppointment();
    }

    @PutMapping("/{id}")
    public AppointmentDto updateAppointment(@PathVariable Long id, @RequestBody AppointmentDto dto){
        return appointmentRepoService.updateAppointment(id,dto);
    }

    @DeleteMapping("/{id}")
    public String deleteMedicine(@PathVariable Long id){
        appointmentRepoService.deleteAppointment(id);
        return "Entry deleted";
    }
}
