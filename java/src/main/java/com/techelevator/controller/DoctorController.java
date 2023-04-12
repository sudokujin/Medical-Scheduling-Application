package com.techelevator.controller;

import com.techelevator.dao.DoctorDao;
import com.techelevator.model.Doctor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/doctors")
@RestController
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
public class DoctorController {
    private final DoctorDao doctorDao;

    public DoctorController(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorDao.getDoctorById(id);
    }

    @GetMapping("")
    public List<Doctor> getAllDoctors() {
        return doctorDao.findAll();
    }


}
