package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.util.List;

public interface AppointmentDao {

    Appointment getAppointmentById (int appointmentId);

    List<Appointment> getAppointmentsByPatientId(int patientId);

    List<Appointment> getAppointmentsByDoctorId(int doctorId);

    void createAppointment(Appointment appointment);

    void updateAppointment(int appointmentId, Appointment appointment);

    void deleteAppointment(int appointmentId);

}
