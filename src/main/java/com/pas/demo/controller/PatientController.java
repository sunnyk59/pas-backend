package com.pas.demo.controller;

import com.pas.demo.handler.PatientHandler;
import com.pas.demo.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "http://localhost:3000") // Allow only your React app to make requests
public class PatientController {

    private PatientHandler patientHandler;

    public PatientController() {
        this.patientHandler = new PatientHandler();
    }

    // Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientHandler.getAllPatients();
    }

    // Get patient by UR number
    @GetMapping("/{urNo}")
    public Patient getPatientByUrNo(@PathVariable int urNo) {
        return patientHandler.getPatientByUrNo(urNo);
    }

    // Create a new patient
    @PostMapping
    public void addPatient(@RequestBody Patient patient) {
        patientHandler.addPatient(patient);
    }

    // Delete a patient by UR number
    @DeleteMapping("/{urNo}")
    public void deletePatient(@PathVariable int urNo) {
        patientHandler.deletePatient(urNo);
    }
}
