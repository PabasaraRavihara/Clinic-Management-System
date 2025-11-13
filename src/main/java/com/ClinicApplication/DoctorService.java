package com.ClinicApplication.service;
import com.ClinicApplication.model.Doctor;
import java.util.List;
public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(long id);
    Doctor updateDoctor(Doctor doctor, long id);
    boolean deleteDoctor(long id);

    Doctor searchByName(String name);
    Doctor filterBySpecialization(String specialization);




}
