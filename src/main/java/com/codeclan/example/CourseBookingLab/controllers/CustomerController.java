package com.codeclan.example.CourseBookingLab.controllers;

import com.codeclan.example.CourseBookingLab.models.Course;
import com.codeclan.example.CourseBookingLab.models.Customer;
import com.codeclan.example.CourseBookingLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomersByCourse(
            @RequestParam(name = "course", required = false) Long courseId,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age)
    { if (courseId != null && town != null && age != null){
        return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseIdAndAgeIsGreaterThan(town, courseId, age), HttpStatus.OK);
    }
        if(courseId != null && town != null){
        return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseId(town, courseId), HttpStatus.OK);
    }
        if (courseId != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseId(courseId), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
