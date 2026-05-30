package com.Hospital.Management.System.controller;

import com.Hospital.Management.System.dto.PatientRequestDto;
import com.Hospital.Management.System.dto.PatientResponseDto;
import com.Hospital.Management.System.service.PatientRepoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientRepoService patientRepoService;

    public PatientController(PatientRepoService patientRepoService){
        this.patientRepoService = patientRepoService;
    }

    //create
    @PostMapping
    public PatientResponseDto createPatient(@Valid @RequestBody PatientRequestDto dto){
        return patientRepoService.createPatient(dto);
    }

    //read
    //by id
    @GetMapping("/{id}")
    public PatientResponseDto getPatientById(@PathVariable Long id){
        return patientRepoService.getPatientById(id);
    }

    //all
    @GetMapping
    public List<PatientResponseDto>getAllPatients(){
        return patientRepoService.getAllPatients();
    }

    //update
    @PutMapping
    public PatientResponseDto updatePatient(@PathVariable Long id, @RequestBody PatientRequestDto dto){
        return patientRepoService.updatePatient(id, dto);
    }

    //delete
    @DeleteMapping("/{id}")

    public String deletePatient(@PathVariable Long id){
        patientRepoService.deletePatient(id);
        return "Entry deleted";
    }






}
