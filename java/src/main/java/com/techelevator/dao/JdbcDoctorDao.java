package com.techelevator.dao;


import com.techelevator.model.Doctor;
import com.techelevator.model.User;
import org.springframework.beans.NullValueInNestedPathException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcDoctorDao implements DoctorDao{

    private JdbcTemplate jdbcTemplate;


    public JdbcDoctorDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Doctor getDoctorById(int doctorId){
        Doctor doctor = null;
        String sql = "select * FROM doctor WHERE doctor_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);

        if(results.next()){
            doctor = mapRowToDoctor(results);
        }
        return doctor;
    }

    @Override
    public List <Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctor;";
        try {
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            doctors.add(mapRowToDoctor(result));
        }
            } catch (NullValueInNestedPathException | EmptyResultDataAccessException e) {
                throw new RuntimeException("No doctor found");
            }
        return doctors;
    }

    @Override
    public int findIdByDoctorLastName(String doctorLastName) {
        if (doctorLastName == null) throw new IllegalArgumentException("Last name cannot be null");

        int doctorId;
        try {
            doctorId = jdbcTemplate.queryForObject("SELECT doctor_id FROM doctor WHERE last_name = ?", int.class, doctorLastName);
        } catch (NullPointerException | EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("User " + doctorLastName + " was not found.");
        }
        return doctorId;
        }

    public boolean create(Doctor doctor) {
        String sql = "INSERT INTO doctor (first_name,last_name,specialty,suite_number, costperhour, appt_date, start_time, end_time) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);" ;
        if (jdbcTemplate.update(sql, doctor.getDoctorId()) == 1) {
            System.out.println("New doctor created");
        } else {
            throw new RuntimeException("Failed to create new doctor");
        }
        return true;
    }

    @Override
    public void updateDoctor(int doctorId, Doctor doctor) {
        String sql = "UPDATE doctor SET first_name=?,last_name,specialty=?," +
                "suite_number=?, costperhour=?, appt_date=?, start_time=?, end_time=? WHERE doctor_id = ?;";
        jdbcTemplate.update(sql,doctor, doctorId);

    }

    @Override
    public boolean deleteDoctorById(int doctorId) {
        String deleteDoctorById = "delete from doctor where doctor_id = ?";
        if (jdbcTemplate.update(deleteDoctorById, doctorId)==1) {
            System.out.println("Doctor is deleted successfully");}
        else{
            throw new RuntimeException("Failed to delete doctor");
            }
        return true;
        }



    private Doctor mapRowToDoctor(SqlRowSet results) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(results.getInt("doctor_id"));
        doctor.setFirstName(results.getString("first_name"));
        doctor.setLastName(results.getString("last_name"));
        doctor.setSpecialty(results.getString("specialty"));
        doctor.setSuiteNumber(results.getInt("suite_number"));
        doctor.setCostPerHour(results.getInt("costperhour"));
        doctor.setDate(results.getDate("appt_date"));
        doctor.setStartTime(results.getTime("start_time"));
        doctor.setEndTime(results.getTime("end_time"));
        return doctor;

    }


}
