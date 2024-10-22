package com.pas.demo.model;

public class Admission {
    private int admissionId;
    private int urNo;
    private int doctorId;
    private int procedureId;
    private String admissionStatus;

    private String doctorName;
    private String procedureName;

    public Admission(int admissionId, int urNo, int doctorId, int procedureId, String doctorName, String procedureName, String admissionStatus) {
        this.admissionId = admissionId;
        this.urNo = urNo;
        this.doctorId = doctorId;
        this.procedureId = procedureId;
        this.doctorName = doctorName;
        this.procedureName = procedureName;
        this.admissionStatus = admissionStatus;
    }

    // Getters and Setters
    public int getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(int admissionId) {
        this.admissionId = admissionId;
    }

    public int getUrNo() {
        return urNo;
    }

    public void setUrNo(int urNo) {
        this.urNo = urNo;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(int procedureId) {
        this.procedureId = procedureId;
    }

    public String getAdmissionStatus() {
        return admissionStatus;
    }

    public void setAdmissionStatus(String admissionStatus) {
        this.admissionStatus = admissionStatus;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }
}