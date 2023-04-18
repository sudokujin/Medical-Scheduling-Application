package com.techelevator.model;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

public class Doctor {
    @NotBlank
    private int doctorId;
    @NotBlank
    private int userId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String specialty;
    private int suiteNumber;
    private int costPerHour;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOfficeHour() {
        return officeHour;
    }

    public void setOfficeHour(String officeHour) {
        this.officeHour = officeHour;
    }

    private String phoneNumber;

    private String officeHour;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
                '}';
    }
}
