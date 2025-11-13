package com.ClinicApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "doctor_name", nullable = false)
    private String name;

    @Column(name = "specialization")
    private String specialization;


    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "teleNumber", nullable = false)
    private String phone;

    @Column(name = "experience", nullable = false)
    private String experience;


    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> schedules;



}