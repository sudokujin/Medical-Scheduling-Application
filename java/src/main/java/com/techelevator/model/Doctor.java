package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Doctor {

    private int doctorId;
    private String firstName;
    private String lastName;
    private String specialty;
    private int suiteNumber;
    private int costPerHour;
    private LocalDate apptDate;
    private int startTime;
    private int endTime;


    public LocalDate getDate() {
        return apptDate;
    }

    public void setDate(LocalDate date) {
        this.apptDate = date;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }


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


    public int getCostPerHour() {
        return costPerHour;
    }

    public void setSuiteNumber(int suiteNumber) {
        this.suiteNumber = suiteNumber;
    }


    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }


}
