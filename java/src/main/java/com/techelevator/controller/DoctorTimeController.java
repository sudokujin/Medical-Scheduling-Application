package com.techelevator.controller;


import com.techelevator.dao.DoctorTimeDao;
import com.techelevator.model.DoctorTime;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@CrossOrigin
@RequestMapping("/time")
@RestController
public class DoctorTimeController {
    private final DoctorTimeDao doctorTimeDao;

    public DoctorTimeController (DoctorTimeDao doctorTimeDao) {
        this.doctorTimeDao = doctorTimeDao;
    }


    @GetMapping("/{id}")
    public DoctorTime getTimeByDoctorId (@PathVariable Integer id) {
        return doctorTimeDao.getDoctorTimeByDoctorId(id);
    }

    @GetMapping("")
    public List<DoctorTime> getAllDoctorTimes() {
        return doctorTimeDao.getAllDoctorTime();
    }

    @DeleteMapping("delete/start/{id}")
    public void deleteStartTimeByDoctorId(@PathVariable Integer id) {
        doctorTimeDao.deleteStartTime(id);
    }

    @DeleteMapping("delete/end/{id}")
    public void deleteEndTimeByDoctorId(@PathVariable Integer id){
        doctorTimeDao.deleteEndTime(id);
    }

    @PutMapping("update/start/{id}")
    public void updateStartTimeByDoctorId(@PathVariable Integer id, DoctorTime doctorTime) {
        doctorTimeDao.updateStartTime(id, doctorTime);
    }

    @PutMapping("update/end/{id}")
    public void updateEndTimeByDoctorId(@PathVariable Integer id, DoctorTime doctorTime) {
        doctorTimeDao.updateEndTime(id, doctorTime);
    }

    @PostMapping("create/start/")
    public void createStartTime(DoctorTime doctorTime) {
        doctorTimeDao.createStartTime(doctorTime);
    }

    @PostMapping("create/end/")
    public void createEndTime(DoctorTime doctorTime) {
        doctorTimeDao.createEndTime(doctorTime);
    }
    @PostMapping("update/startandend/{id}")
    public void getTimeByDoctorId(@PathVariable Integer id, Time startTime, Time endTime) {
        doctorTimeDao.changeStartTimeAndEndTimeByDoctorId(id, startTime, endTime);
    }



}
