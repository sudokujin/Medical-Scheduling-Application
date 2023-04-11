package com.techelevator.dao;


import com.techelevator.model.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcDoctorDao implements DoctorDao{

    private JdbcTemplate jdbcTemplate;


    public JdbcDoctorDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Doctor getDoctorById(int doctorId){
        Doctor doctor = null;
        String sql = "SELECT *" + "FROM doctor" + "WHERE doctor_id = ?" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);

        if(results.next()){
            doctor = mapRowToDoctor(results);
        }
        return doctor;
    }

    private Doctor mapRowToDoctor(SqlRowSet results) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(results.getInt("doctor_id"));
        doctor.setUserId(results.getInt("user_id"));
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
