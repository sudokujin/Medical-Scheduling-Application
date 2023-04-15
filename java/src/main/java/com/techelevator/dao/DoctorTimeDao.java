package com.techelevator.dao;

import com.techelevator.model.DoctorTime;

import java.util.List;

public interface DoctorTimeDao {


    DoctorTime getDoctorTimeByTimeId (int doctorTimeId);

    DoctorTime getDoctorTimeByDoctorId (int doctorId);

    DoctorTime getOfficeDateByDoctorId (int doctorId);

    DoctorTime getStartTimeByDoctorId (int doctorId);

//    DoctorTime getEndTimeByDoctorId (int doctorId);

//    List<Appointment> getAppointmentsByPatientId(int patientId);
//
//    List<Appointment> getAppointmentsByDoctorId(int doctorId);
//
//    void createAppointment(Appointment appointment);
//
//    void updateAppointment(int appointmentId, Appointment appointment);
//
//    void deleteAppointment(int appointmentId);
}
