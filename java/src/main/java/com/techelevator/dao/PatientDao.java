package com.techelevator.dao;

import com.techelevator.model.Patient;

import java.util.List;

public interface PatientDao {
    String getPatientName();

    List<Patient> findAllPatients();

    Patient getPatientById(int patientId);

    int findPatientIdByPatientLastName (String patientLastName);

    void create(Patient patient);

    void deletePatientById(int patientId);

    Integer getMaxId();

    void updatePatient (int patientId, Patient patient);
}
