package com.Hospital.Management.System.service.impl;

import com.Hospital.Management.System.dto.MedicineDto;
import com.Hospital.Management.System.entity.Medicine;
import com.Hospital.Management.System.exception.ResourceNotFoundException;
import com.Hospital.Management.System.repository.MedicineRepository;
import com.Hospital.Management.System.service.MedicineRepoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineRepoServiceImpl implements MedicineRepoService {

    private final MedicineRepository medicineRepository;

    public MedicineRepoServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }


    @Override
    public MedicineDto createMedicine(MedicineDto dto) {
        Medicine medicine = new Medicine();
        medicine.setDrugName(dto.getDrugName());
        medicine.setStock(dto.getStock());

        Medicine savedMedicine = medicineRepository.save(medicine);
        return mapToDto(savedMedicine);
    }

    @Override
    public List<MedicineDto> getAllMedicine() {
        return medicineRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MedicineDto getMedicineById(Long id) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No record found"));
        return mapToDto(medicine);

    }

    @Override
    public MedicineDto updateMedicine(Long id, MedicineDto dto) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No record found"));
        medicine.setDrugName(dto.getDrugName());
        medicine.setStock(dto.getStock());

        Medicine savedMedicine = medicineRepository.save(medicine);
        return mapToDto(savedMedicine);
    }

    @Override
    public String deleteMedicine(Long id) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No record found"));
        medicineRepository.delete(medicine);
        return "Item deleted";

    }

    private MedicineDto mapToDto(Medicine dto){
        return new MedicineDto(
                dto.getDrugName(),
                dto.getStock()
        );
    }
}
