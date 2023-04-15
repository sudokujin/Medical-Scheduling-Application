package com.techelevator.controller;


import com.techelevator.dao.DoctorTimeDao;
import com.techelevator.model.DoctorTime;
import org.springframework.web.bind.annotation.*;

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
}
