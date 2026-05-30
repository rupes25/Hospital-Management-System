package com.Hospital.Management.System.service.impl;

import com.Hospital.Management.System.dto.PatientRequestDto;
import com.Hospital.Management.System.dto.PatientResponseDto;
import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repository.PatientRepository;
import com.Hospital.Management.System.service.PatientRepoService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientRepoServiceImpl implements PatientRepoService {

    private final PatientRepository patientRepository;

    public PatientRepoServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public PatientResponseDto createPatient(PatientRequestDto dto) {
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setBlood(dto.getBlood());
        patient.setPrescription(dto.getPrescription());
        patient.setDose(dto.getDose());
        patient.setFees(dto.getFees());
        patient.setUrgency(dto.getUrgency());

        Patient savedPatient = patientRepository.save(patient);

        return mapToDto(savedPatient);

    }

    @Override
    public List<PatientResponseDto> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PatientResponseDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()->new ResourceAccessException("No record found"));
        return mapToDto(patient);
    }

    @Override
    public PatientResponseDto updatePatient(Long id, PatientRequestDto dto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()->new ResourceAccessException("No record found"));
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setBlood(dto.getBlood());
        patient.setPrescription(dto.getPrescription());
        patient.setDose(dto.getDose());
        patient.setFees(dto.getFees());
        patient.setUrgency(dto.getUrgency());

        Patient savedPatient = patientRepository.save(patient);
        return mapToDto(savedPatient);
    }

    @Override
    public String deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()->new ResourceAccessException("No record found"));
        patientRepository.delete(patient);
        return "Entry deleted";
    }

    private PatientResponseDto mapToDto(Patient patient){
            return  new PatientResponseDto(
                    patient.getId(),
                    patient.getName(),
                    patient.getAge(),
                    patient.getBlood(),
                    patient.getPrescription(),
                    patient.getDose(),
                    patient.getFees(),
                    patient.getUrgency()
            );
    }
}
