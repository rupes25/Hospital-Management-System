package com.Hospital.Management.System.repository;

import com.Hospital.Management.System.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
}
