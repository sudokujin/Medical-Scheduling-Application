package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.DoctorTime;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface DoctorTimeDao {


    DoctorTime getDoctorTimeByTimeId (int doctorTimeId);

    List<DoctorTime> getAllDoctorTime();

    DoctorTime getStartTimeByDoctorIdDate (int doctorId, Date officeDate);

    DoctorTime getEndTimeByDoctorIdDate (int doctorId, Date officeDate);

    void changeStartTimeAndEndTimeByDoctorId(int doctorId, Time startTime, Time endTime);

    void createStartTime(DoctorTime doctorTime);

    void updateStartTime(int doctorTimeId, DoctorTime doctorTime);

    void deleteStartTime(int doctorTimeId);

    void createEndTime(DoctorTime doctorTime);

    void updateEndTime(int doctorTimeId, DoctorTime doctorTime);

    void deleteEndTime(int doctorTimeId);
}
