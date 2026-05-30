package com.Hospital.Management.System.repository;

import com.Hospital.Management.System.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
