package com.pas.demo.handler;

import com.pas.demo.model.Patient;
import com.pas.demo.services.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientHandler {
    private DAO dao;

    public PatientHandler() {
        dao = new DAO();
    }

    // Create a new Patient
    public void addPatient(Patient patient) {
        String query = "INSERT INTO Patient (ur_no, name, age) VALUES (" + patient.getUrNo() + ", '" + patient.getName()
                + "', " + patient.getAge() + ")";
        dao.executeQuery(query);
    }

    // Retrieve all Patients
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM Patient";
        ResultSet rs = dao.executeFetch(query);

        try {
            while (rs.next()) {
                Patient patient = new Patient(
                        rs.getInt("ur_no"),
                        rs.getString("name"),
                        rs.getInt("age"));
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    // Find Patient by UR Number
    public Patient getPatientByUrNo(int urNo) {
        String query = "SELECT * FROM Patient WHERE ur_no = " + urNo;
        ResultSet rs = dao.executeFetch(query);

        Patient patient = null;
        try {
            if (rs.next()) {
                patient = new Patient(
                        rs.getInt("ur_no"),
                        rs.getString("name"),
                        rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    // Delete Patient by UR Number
    public void deletePatient(int urNo) {
        String query = "DELETE FROM Patient WHERE ur_no = " + urNo;
        dao.executeQuery(query);
    }
}
