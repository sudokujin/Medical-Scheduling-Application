package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.Availability;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JdbcAvailabilityDao implements AvailabilityDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAvailabilityDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Availability getAvailabilityByDoctorIdDate(int doctorId, Date availableDate){
        Availability availability = null;
        String sql = "SELECT * " + "FROM availability " + "WHERE doctor_id = ? AND appt_date = ?" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId, availableDate);

        if(results.next()){
            availability = mapRowToAvailability(results);
        }
        return availability;
    }


    @Override
    public void createAppointment(Availability availability) {
        String sql = "INSERT INTO availability(patient_id, doctor_id, appt_date, appt_time) VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(sql, availability.getPatientId(), availability.getDoctorId(), availability.getApptDate(), availability.getApptTime());
    }


    private Availability mapRowToAvailability(SqlRowSet results) {
        Availability availability = new Availability();
        availability.setAvailabilityId(results.getInt("availability_id"));
        availability.setPatientId(results.getInt("patient_id"));
        availability.setDoctorId(results.getInt("doctor_id"));
        availability.setApptDate(results.getDate("appt_date"));
        availability.setApptTime(results.getString("appt_time"));
        return availability;

    }
}
