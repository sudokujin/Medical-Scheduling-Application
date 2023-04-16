package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.model.Appointment;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/appointments")
@RestController
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
public class AppointmentController {
    private final AppointmentDao appointmentDao;

    public AppointmentController(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable int id) {
        return appointmentDao.getAppointmentById(id);
    }
    @GetMapping("/patient/{id}")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable int id) {
        return appointmentDao.getAppointmentsByPatientId(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createAppointment(@Valid @RequestBody Appointment appointment) {
        appointmentDao.createAppointment(appointment);
    }
    @GetMapping("/doctor/{id}")
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable int id) {
        return appointmentDao.getAppointmentsByDoctorId(id);
    }
    @PutMapping("/{id}")
    public void updateAppointment(@PathVariable int id, @Valid @RequestBody Appointment appointment){
        appointmentDao.updateAppointment(id, appointment);
    }
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable int id) {
        appointmentDao.deleteAppointment(id);
    }
}


