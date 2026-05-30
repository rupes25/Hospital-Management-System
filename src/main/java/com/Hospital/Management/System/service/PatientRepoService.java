package com.Hospital.Management.System.service;


import com.Hospital.Management.System.dto.PatientRequestDto;
import com.Hospital.Management.System.dto.PatientResponseDto;
import com.Hospital.Management.System.entity.Patient;

import java.util.List;

public interface PatientRepoService  {
    //create
    PatientResponseDto createPatient(PatientRequestDto dto);

    //read
    //all
    List<PatientResponseDto>getAllPatients();

    //by id
    PatientResponseDto getPatientById(Long id);

    //update

    PatientResponseDto updatePatient(Long id, PatientRequestDto dto);

    //delete

    String deletePatient(Long id);

}
