package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AppointmentDao {

    List <Appointment> getAppointments();

    Appointment getAppointmentById (int appointmentId);

    List<Appointment> getAppointmentsByDoctorIdDate(int doctorId, LocalDate officeDate);

    List<Appointment> getAppointmentsByPatientId(int patientId);

    List<Appointment> getAppointmentsByDoctorId(int doctorId);

    void createAppointment(Appointment appointment);

    void updateAppointment(int appointmentId, Appointment appointment);

    void deleteAppointment(int appointmentId);

}

