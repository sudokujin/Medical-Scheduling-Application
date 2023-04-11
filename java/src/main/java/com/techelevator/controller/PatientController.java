//package com.techelevator.controller;
//
//import com.techelevator.model.Doctor;
//import com.techelevator.model.Patient;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RequestMapping("/patients")
//@RestController
//@CrossOrigin
//@PreAuthorize("isAuthenticated()")
//public class PatientController {
//    public PatientController(PatientDao patientDao) {
//        this.patientDao = patientDao;
//    }
//    @GetMapping("/{id}")
//    public Patient getPatientById(@PathVariable int id) {
//        return patientDao.getPatientById(id);
//    }
//
//    @GetMapping("")
//    public List<Patient> getAllPatients() {
//        return patientDao.findAllPatients();
//    }
//}
