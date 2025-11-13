package com.ClinicApplication.service.Impl;
import com.ClinicApplication.model.Doctor;
import com.ClinicApplication.Repositary.DoctorRepositary;
import com.ClinicApplication.service.DoctorService;
//import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepositary doctorRepositary;

    // Save doctor in the database
    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepositary.save(doctor);
    }

    // Get all doctors from the database
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepositary.findAll();
    }

    // Get doctor by ID
    @Override
    public Doctor getDoctorById(long id) {
        return doctorRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    // Update doctor
    @Override
    public Doctor updateDoctor( Doctor doctor, long id) {
        Doctor existingDoctor = doctorRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

        existingDoctor.setName(doctor.getName());
        existingDoctor.setSpecialization(doctor.getSpecialization());
        existingDoctor.setEmail(doctor.getEmail());
        existingDoctor.setPhone(doctor.getPhone());

        doctorRepositary.save(existingDoctor);
        return existingDoctor;
    }

    // Delete doctor
    @Override
    public boolean deleteDoctor(long id) {
        doctorRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

        doctorRepositary.deleteById(id);
        return false;
    }
    @Override
    public Doctor searchByName(String name) {
        return doctorRepositary.findByNameContainingIgnoreCase(name);
    }
    @Override
    public Doctor filterBySpecialization(String specialization) {
        return doctorRepositary.findBySpecialization(specialization);
    }
}
