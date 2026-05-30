package com.Hospital.Management.System.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 0, max = 30, message ="Name must be between 3 to 30 characters")
    private String name;

    @NotNull(message = "Age cannot be empty")
    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 100, message = "Age cannot be more than 100 years")
    private Integer age;

    @NotBlank(message = "Provide the symptoms")
    @Size(min = 5, max = 30, message ="Make it brief")
    private String symptoms;

    @NotNull(message = "Provide your phone number")
    @Min(value = 10, message = "Invalid number")
    @Max(value = 10, message = "Invalid number")
    private String number;
}
