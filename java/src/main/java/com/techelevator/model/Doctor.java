package com.techelevator.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

public class Doctor {

    private int doctorId;
    private String firstName;
    private String lastName;
    private String specialty;
    private int suiteNumber;
    private int costPerHour;
    private Date apptDate;
    private Time startTime;
    private Time endTime;

    public Date getDate() {
        return apptDate;
    }

    public void setDate(Date date) {
        this.apptDate = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
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

    public Doctor() {
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", suiteNumber=" + suiteNumber +
                ", costPerHour=" + costPerHour +
                ", apptDate=" + apptDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
