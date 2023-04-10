package com.techelevator.model;

import java.time.LocalDateTime;

public class Doctor {

    private int doctorId;
    private String firstName;
    private String lastName;
    private String specialty;
    private int suiteNumber;
    private LocalDateTime officeHours;
    private int costPerHour;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getSuiteNumber() {
        return suiteNumber;
    }

    public LocalDateTime getOfficeHours() {
        return officeHours;
    }

    public int getCostPerHour() {
        return costPerHour;
    }

    public void setSuiteNumber(int suiteNumber) {
        this.suiteNumber = suiteNumber;
    }

    public void setOfficeHours(LocalDateTime officeHours) {
        this.officeHours = officeHours;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }


}
