package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.Patient;
import com.techelevator.model.User;

import java.util.List;

public interface PatientDao {
    List<Patient> findAllPatients();

    Patient getPatientById(int patientId);

    int findPatientIdByPatientLastName (String patientLastName);

    void create(Patient patient);

    void deletePatientById(int patientId);

    void updatePatient (int patientId, Patient patient);
}
