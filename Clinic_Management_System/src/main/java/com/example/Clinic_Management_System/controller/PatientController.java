package com.example.Clinic_Management_System.controller;



import com.example.Clinic_Management_System.model.Patient;
import com.example.Clinic_Management_System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        return new ResponseEntity<Patient>(patientService.savePatient(patient), HttpStatus.CREATED);
    }

    //GetAll Rest Api
    @GetMapping
    public List<Patient> getAllPatient(){
        return patientService.getAllPatient();
    }

    //Get by Id Rest Api
    @GetMapping("{id}") // localhost:8080/api/patients/1
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") long patientId){
        return new ResponseEntity<Patient>(patientService.getPatientById(patientId), HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id, @RequestBody Patient patient){
        return new ResponseEntity<Patient>(patientService.updatePatient(patient, id), HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") long id){
        //delete patient from db
        patientService.deletePatient(id);
        return new ResponseEntity<String>("Patient deleted Successfully.", HttpStatus.OK);
    }
}
