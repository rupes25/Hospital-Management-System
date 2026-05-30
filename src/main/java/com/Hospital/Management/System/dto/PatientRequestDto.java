package com.Hospital.Management.System.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequestDto {
    private String name;
    private Integer age;
    private String blood;
    private String prescription;
    private String dose;
    private Integer fees;
    private String urgency;
}
