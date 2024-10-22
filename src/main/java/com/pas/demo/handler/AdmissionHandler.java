package com.pas.demo.handler;

import java.sql.*;
import com.pas.demo.model.Admission;
import java.util.ArrayList;
import java.util.List;

import com.pas.demo.services.DAO;

public class AdmissionHandler {

    private DAO dao = new DAO();

    // Admit a new patient
    public void admitNewPatient(Admission admission) {
        String query = "INSERT INTO Admission (ur_no, doctor_id, procedure_id, admission_status) VALUES ("
                + admission.getUrNo() + ", "
                + admission.getDoctorId() + ", "
                + admission.getProcedureId() + ", '"
                + admission.getAdmissionStatus() + "')";
        dao.executeQuery(query);
    }

    // Get all admissions with doctor and procedure names
    public List<Admission> getAllAdmissions() {
        List<Admission> admissions = new ArrayList<>();
        String query = "SELECT a.admission_id, a.ur_no, a.doctor_id, a.procedure_id,"
                + "a.admission_status, d.doctor_name, p.procedure_name "
                + "FROM Admission a "
                + "JOIN Doctor d ON a.doctor_id = d.doctor_id "
                + "JOIN Procedure p ON a.procedure_id = p.procedure_id";

        ResultSet resultSet = dao.executeFetch(query);
        try {
            while (resultSet.next()) {
                int admissionId = resultSet.getInt("admission_id");
                int urNo = resultSet.getInt("ur_no");
                int doctorId = resultSet.getInt("doctor_id");
                int procedureId = resultSet.getInt("procedure_id");
                String doctorName = resultSet.getString("doctor_name");
                String procedureName = resultSet.getString("procedure_name");
                String admissionStatus = resultSet.getString("admission_status");

                Admission admission = new Admission(admissionId, urNo, doctorId, procedureId, doctorName, procedureName,
                        admissionStatus);
                admissions.add(admission);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admissions;
    }
}