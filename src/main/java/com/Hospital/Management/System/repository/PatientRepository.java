package com.Hospital.Management.System.repository;

import com.Hospital.Management.System.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
