package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private int appointmentDuration;
    private String description;

    public int getAppointmentDuration() {
        return appointmentDuration;
    }

    public void setAppointmentDuration(int appointmentDuration) {
        this.appointmentDuration = appointmentDuration;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Appointment(LocalDate appointmentDate, LocalTime appointmentTime, int appointmentId, int patientId, int doctorId, int appointmentDuration, String description) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDuration = appointmentDuration;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", appointmentId=" + appointmentId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", appointmentDuration=" + appointmentDuration +
                ", description='" + description + '\'' +
                '}';
    }
}
