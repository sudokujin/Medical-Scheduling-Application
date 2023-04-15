package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.DoctorTime;

import java.util.List;

public interface DoctorTimeDao {


    DoctorTime getDoctorTimeByTimeId (int doctorTimeId);

    DoctorTime getDoctorTimeByDoctorId (int doctorId);

    DoctorTime getOfficeDateByDoctorId (int doctorId);

    DoctorTime getStartTimeByDoctorId (int doctorId);

    DoctorTime getEndTimeByDoctorId (int doctorId);

    void createStartTime(DoctorTime doctorTime);

    void updateStartTime(int doctorTimeId, DoctorTime doctorTime);

    void deleteStartTime(int doctorTimeId);

    void createEndTime(DoctorTime doctorTime);

    void updateEndTime(int doctorTimeId, DoctorTime doctorTime);

    void deleteEndTime(int doctorTimeId);
}
