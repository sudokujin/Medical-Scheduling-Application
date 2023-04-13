package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.User;

import java.util.List;

public interface DoctorDao {

    List<Doctor> findAll();

    Doctor getDoctorById(int doctorId);

    int findIdByDoctorLastName (String doctorLastName);

    boolean create(Doctor doctor);

    void updateDoctor (int doctorId, Doctor doctor);

    boolean deleteDoctorById(int doctorId);

    boolean isDoctor();

}
