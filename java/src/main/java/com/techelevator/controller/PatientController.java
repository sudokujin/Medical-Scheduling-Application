package com.techelevator.controller;

import com.techelevator.dao.PatientDao;
import com.techelevator.model.Doctor;
import com.techelevator.model.Patient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/patients")
@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PatientController {

    private final PatientDao patientDao;
    public PatientController(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable int id) {
        return patientDao.getPatientById(id);
    }

    @GetMapping("")
    public List<Patient> getAllPatients() {
        return patientDao.findAllPatients();
    }

    @PostMapping("")
    public void createPatient(@Valid @RequestBody Patient patient) {
        patientDao.create(patient);
    }

    @PutMapping("/{id}")
    public void updatePatient(@PathVariable int id, @Valid @RequestBody Patient patient) {
        patientDao.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable int id, @Valid @RequestBody Patient patient) {
        patientDao.deletePatientById(id);
    }
}
