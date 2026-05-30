package com.Hospital.Management.System.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "drug_name")
    private String drugName;

    private String stock;

}
