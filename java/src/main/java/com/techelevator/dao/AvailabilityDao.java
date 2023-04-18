package com.techelevator.dao;

import com.techelevator.model.Availability;

import java.util.Date;

public interface AvailabilityDao {

    Availability getAvailabilityByDoctorIdDate (int doctorId, Date availableDate);

    void createAppointment(Availability availability);

}
