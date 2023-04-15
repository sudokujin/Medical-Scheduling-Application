package com.techelevator.dao;



import com.techelevator.model.Appointment;
import com.techelevator.model.DoctorTime;
import org.springframework.beans.NullValueInNestedPathException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcDoctorTimeDao implements DoctorTimeDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcDoctorTimeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public DoctorTime getDoctorTimeByTimeId(int doctorTimeId){
        DoctorTime doctorTime = null;
        String sql = "SELECT * " + "FROM doctor_time " + "WHERE doctor_time_id = ?" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorTimeId);

        if(results.next()){
            doctorTime = mapRowToDoctorTime(results);
        }
        return doctorTime;
    }

    @Override
    public DoctorTime getDoctorTimeByDoctorId(int doctorId) {
        DoctorTime doctorTime = null;
        String sql = "SELECT * FROM doctor_time JOIN doctor ON doctor_time.doctor_id=doctor.doctor_id WHERE doctor.doctor_id = ?;" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);

        if(results.next()){
            doctorTime = mapRowToDoctorTime(results);
        }
        return doctorTime;
    }

    private DoctorTime mapRowToDoctorTime(SqlRowSet results) {
        DoctorTime doctorTime = new DoctorTime();
        doctorTime.setDoctorTimeId(results.getInt("doctor_time_id"));
        doctorTime.setDoctorId(results.getInt("doctor_id"));
        doctorTime.setOfficeDate(results.getDate("office_date"));
        doctorTime.setStart_time(results.getTime("start_time"));
        doctorTime.setEnd_time(results.getTime("end_time"));

        return doctorTime;

    }


}
