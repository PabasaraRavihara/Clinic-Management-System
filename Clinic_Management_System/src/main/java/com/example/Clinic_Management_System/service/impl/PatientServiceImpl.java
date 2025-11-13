package com.example.Clinic_Management_System.service.impl;


import com.example.Clinic_Management_System.model.Patient;
import com.example.Clinic_Management_System.repository.PatientRepository;
import com.example.Clinic_Management_System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    //save patient in database
    @Override
    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }

    //get all patient form database
    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    //get patient using id
    @Override
    public Patient getPatientById(long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent()){
            return patient.get();
        }else {
            throw new RuntimeException("Patient not found with id: " + id);
        }
    }

    //update patient
    @Override
    public Patient updatePatient(Patient patient, long id) {
        Patient existingPatient = patientRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Patient not found with id: " + id)
        );
        existingPatient.setName(patient.getName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        existingPatient.setContactNo(patient.getContactNo());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setRegisteredAt(patient.getRegisteredAt());
        // save
        patientRepository.save(existingPatient);
        return existingPatient;
    }

    //delete patient
    @Override
    public void deletePatient(long id) {
        //check if patient exists
        patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        //delete
        patientRepository.deleteById(id);
    }
}