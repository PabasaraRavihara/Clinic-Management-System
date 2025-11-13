package com.example.Clinic_Management_System.service;



import com.example.Clinic_Management_System.model.Patient;
import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient> getAllPatient();
    Patient getPatientById(long id);
    Patient updatePatient(Patient patient, long id);
    void deletePatient(long id);
}