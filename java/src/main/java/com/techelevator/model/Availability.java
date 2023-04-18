package com.techelevator.model;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

public class Availability {
    private int availabilityId;
    private int doctorId;
    private int patientId;
    private LocalDate apptDate;
    private String apptTime;

    public int getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(int availabilityId) {
        this.availabilityId = availabilityId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public LocalDate getApptDate() {
        return apptDate;
    }

    public void setApptDate(LocalDate apptDate) {
        this.apptDate = apptDate;
    }

    public String getApptTime() {
        return apptTime;
    }

    public void setApptTime(String apptTime) {
        this.apptTime = apptTime;
    }



}
