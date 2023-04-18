package com.techelevator.controller;


import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.DoctorTimeDao;
import com.techelevator.model.DoctorTime;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@CrossOrigin
@RequestMapping("/time")
@RestController
public class DoctorTimeController {
    private final DoctorTimeDao doctorTimeDao;
    private final AppointmentDao appointmentDao;

    public DoctorTimeController (DoctorTimeDao doctorTimeDao, AppointmentDao appointmentDao) {
        this.doctorTimeDao = doctorTimeDao;
        this.appointmentDao = appointmentDao;
    }

//    @GetMapping("/{id}")
//    public DoctorTime getTimeByDoctorId (@PathVariable Integer id) {
//        return doctorTimeDao.getDoctorTimeByDoctorId(id);
//    }

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
    public void updateBothStartAndEndTimeByDoctorId(@PathVariable Integer id, Time startTime, Time endTime) {
        doctorTimeDao.changeStartTimeAndEndTimeByDoctorId(id, startTime, endTime);
    }


    @GetMapping("/222")
    public String getTime() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
        Date date = formatter.parse("2023-12-20");
        try {
            return doctorTimeDao.getStartTimeByDoctorIdDate(1, date).getStart_time().toString();
        } catch (EmptyResultDataAccessException e) {
            return "Woops";
        }
    }

    @GetMapping("/array")
    public ArrayList<String> blah(Integer id, Date date) throws ParseException {
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date first = localDateFormat.parse("08:00:00");
        Date second = localDateFormat.parse("17:00:00");


        Date next = first;
        ArrayList<String> arr = new ArrayList<>();
        do {
            System.out.println(localDateFormat.format(next));
            String time = (String) localDateFormat.format(next);
//            java.sql.Time timeValue = new java.sql.Time(localDateFormat.parse(time).getTime());
//            System.out.println(timeValue);
            arr.add(time);
        } while ((next = new Date(next.getTime() + 1800000
        )).before(second));

        //Get Doctor Start and End Time

        doctorTimeDao.getStartTimeByDoctorIdDate(id, date);
        doctorTimeDao.getEndTimeByDoctorIdDate(id, date);
        //TODO: Exclude breaks

        // Exclude booked appointments
        appointmentDao.getAppointmentsByDoctorIdDate(id, date);


//        Array of Times available for Doctor
//                Doctor Start and End Time by their ID
//                Start and End Time by the Date (because time can be different depending on day)
//
//                -
//                Booked Appointments
//                Get by (Doctor Id , Appointment Date)
//                        Time



        //Return available hours
        return arr;
    }

    @PostMapping("/array")
    public ArrayList<String> poopoo() throws ParseException {
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date first = localDateFormat.parse("08:00:00");
        Date second = localDateFormat.parse("17:00:00");


        Date next = first;
        ArrayList<String> arr = new ArrayList<>();
        do {
            System.out.println(localDateFormat.format(next));
            String time = (String) localDateFormat.format(next); // <== Only changed line (and using a deprecated API)
            java.sql.Time timeValue = new java.sql.Time(localDateFormat.parse(time).getTime());
            System.out.println(timeValue);
            arr.add(time);
        } while ((next = new Date(next.getTime() + 1800000
        )).before(second));
        return arr;
    }
}
