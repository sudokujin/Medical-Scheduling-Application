package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.DoctorTime;

import java.sql.Time;
import java.util.List;

public interface DoctorTimeDao {


    DoctorTime getDoctorTimeByTimeId (int doctorTimeId);

    List<DoctorTime> getAllDoctorTime();

    DoctorTime getDoctorTimeByDoctorId (int doctorId);

    DoctorTime getOfficeDateByDoctorId (int doctorId);

    DoctorTime getStartTimeByDoctorId (int doctorId);

    DoctorTime getEndTimeByDoctorId (int doctorId);

    void changeStartTimeAndEndTimeByDoctorId(int doctorId, Time startTime, Time endTime);

    void createStartTime(DoctorTime doctorTime);

    void updateStartTime(int doctorTimeId, DoctorTime doctorTime);

    void deleteStartTime(int doctorTimeId);

    void createEndTime(DoctorTime doctorTime);

    void updateEndTime(int doctorTimeId, DoctorTime doctorTime);

    void deleteEndTime(int doctorTimeId);
}
