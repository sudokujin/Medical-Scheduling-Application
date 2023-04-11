package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.User;

import java.util.List;

public interface DoctorDao {

    List<Doctor> findAll();

    Doctor getDoctorById(int doctorId);

    User findByDoctorLastName(String doctorLastName);

    int findIdByDoctorLastName (String doctorLastName);
    //need doc ID to write review and make appt

    boolean create(String doctorLastName, String doctorFirstName, String password, String role);
}
