package com.Hospital.Management.System.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 3, max = 20, message = "Name must be between 3 to 30 characters")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Age cannot be empty")
    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 100, message = "Age cannot be more than 100 years")
    @Column(name = "age")
    private Integer age;

    @NotBlank(message = "Please provide a blood group")
    @Pattern(
            regexp = "^(A|B|AB|O)[+-]$",
            message = "Invalid blood group"
    )
    @Column(name = "blood_group")
    private String blood;


    @Column(name = "prescription")
    private String prescription;

    @Column(name = "dose")
    private String dose;

    @Column(name = "fees")
    private Integer fees;

    @NotBlank
    @Pattern(
            regexp = "LOW|MEDIUM|HIGH",
            message = "urgency must be between low, medium or high"
    )
    @Column(name = "urgency")
    private String urgency;


}
