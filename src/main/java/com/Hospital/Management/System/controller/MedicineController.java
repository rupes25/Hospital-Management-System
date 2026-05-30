package com.Hospital.Management.System.controller;

import com.Hospital.Management.System.dto.MedicineDto;
import com.Hospital.Management.System.service.MedicineRepoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    private final MedicineRepoService medicineRepoService;

    public MedicineController(MedicineRepoService medicineRepoService) {
        this.medicineRepoService = medicineRepoService;
    }

    //create
    @PostMapping
    public MedicineDto createMedicine(@Valid @RequestBody MedicineDto dto){
        return medicineRepoService.createMedicine(dto);
    }

    //by id
    @GetMapping
    public MedicineDto getMedicineById(@PathVariable Long id){
        return medicineRepoService.getMedicineById(id);
    }

    @GetMapping
    public List<MedicineDto>getAllMedicine(){
        return medicineRepoService.getAllMedicine();
    }

    //update
    @PutMapping
    public MedicineDto updateMedicine(@PathVariable Long id, @RequestBody MedicineDto dto){
        return medicineRepoService.updateMedicine(id, dto);
    }

    //delete
    public String deleteMedicine(@PathVariable Long id){
        medicineRepoService.deleteMedicine(id);
        return "Entry deleted";
    }
}

