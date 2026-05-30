package com.Hospital.Management.System.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDto {
    private Long id;
    private String name;
    private Integer age;
    private String blood;
    private String prescription;
    private String dose;
    private Integer fees;
    private String urgency;
}
