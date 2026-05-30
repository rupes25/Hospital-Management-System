package com.Hospital.Management.System.entity;

import jakarta.persistence.*;
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

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "blood_group")
    private String blood;

    @Column(name = "prescription")
    private String prescription;

    @Column(name = "dose")
    private String dose;

    @Column(name = "fees")
    private String fees;

    @Column(name = "urgency")
    private String urgency;


}
