package com.techelevator.model;

import java.sql.Time;
import java.util.Date;

public class DoctorTimeTable {
    private int doctorTimeTableId;
    private int doctorId;
    private Date date;
    private Time start_time;
    private Time end_time;

    public DoctorTimeTable() { }

    public int getDoctorTimeTableId() {
        return doctorTimeTableId;
    }

    public void setDoctorTimeTableId(int doctorTimeTableId) {
        this.doctorTimeTableId = doctorTimeTableId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }


}
