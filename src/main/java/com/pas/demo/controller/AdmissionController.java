package com.pas.demo.controller;

import com.pas.demo.model.Admission;
import com.pas.demo.handler.AdmissionHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admissions")
@CrossOrigin(origins = "http://localhost:3000") // Allow only your React app to access this endpoint
public class AdmissionController {

    private AdmissionHandler admissionHandler = new AdmissionHandler();

    @PostMapping("/admit")
    public void admitNewPatient(@RequestBody Admission admission) {
        admissionHandler.admitNewPatient(admission);
    }

    @GetMapping
    public List<Admission> getAllAdmissions() {
        return admissionHandler.getAllAdmissions();
    }
}