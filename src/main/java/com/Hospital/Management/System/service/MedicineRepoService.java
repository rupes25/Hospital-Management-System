package com.Hospital.Management.System.service;

import com.Hospital.Management.System.dto.MedicineDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineRepoService {
    MedicineDto createMedicine(MedicineDto dto);
    List<MedicineDto>getAllMedicine();
    MedicineDto getMedicineById(Long id);
    MedicineDto updateMedicine(Long id, MedicineDto dto);
    String deleteMedicine(Long id);
}
