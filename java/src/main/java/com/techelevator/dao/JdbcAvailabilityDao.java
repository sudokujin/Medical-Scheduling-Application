package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.Availability;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JdbcAvailabilityDao implements AvailabilityDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAvailabilityDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void createAppointment(Availability availability) {
        String sql = "INSERT INTO availability(patient_id, doctor_id, appt_date, appt_time) VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(sql, availability.getPatientId(), availability.getDoctorId(), availability.getApptDate(), availability.getApptTime());
    }
}
