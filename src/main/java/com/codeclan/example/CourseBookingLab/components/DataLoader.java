package com.codeclan.example.CourseBookingLab.components;

import com.codeclan.example.CourseBookingLab.models.Booking;
import com.codeclan.example.CourseBookingLab.models.Course;
import com.codeclan.example.CourseBookingLab.models.Customer;
import com.codeclan.example.CourseBookingLab.repositories.BookingRepository;
import com.codeclan.example.CourseBookingLab.repositories.CourseRepository;
import com.codeclan.example.CourseBookingLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    public void run(ApplicationArguments args) throws Exception {

        Course pythonCourse = new Course("Intro to Python", "Edinburgh", 4);
        courseRepository.save(pythonCourse);

        Course jsCourse = new Course("Javascript for Noobs", "Glasgow", 3);
        courseRepository.save(jsCourse);

        Course javaCourse = new Course("Java for Pros", "London", 5);
        courseRepository.save(javaCourse);

        Customer princess = new Customer("Princess", "Edinburgh", 24);
        customerRepository.save(princess);

        Customer cameron = new Customer("Cameron", "Edinburgh", 28);
        customerRepository.save(cameron);

        Customer connor = new Customer("Connor", "Edinburgh", 28);
        customerRepository.save(connor);

        Customer craig = new Customer("Craig", "Aberdeen", 30);
        customerRepository.save(craig);

        Customer nathan = new Customer("Nathan", "Glasgow", 30);
        customerRepository.save(nathan);

        Booking nathanPythonBooking = new Booking("11-10-21", nathan, pythonCourse);
        bookingRepository.save(nathanPythonBooking);

        Booking craigPythonBooking = new Booking("11-10-21", craig, pythonCourse);
        bookingRepository.save(craigPythonBooking);

        Booking connorJsBooking = new Booking("15-10-21", connor, jsCourse);
        bookingRepository.save(connorJsBooking);

        Booking cameronJavaBooking = new Booking("16-10-21", cameron, javaCourse);
        bookingRepository.save(cameronJavaBooking);

        Booking princessPythonBooking = new Booking("11-10-21", princess, pythonCourse);
        bookingRepository.save(princessPythonBooking);

        Booking princessJsCourseBooking = new Booking("15-10-21", princess, jsCourse);
        bookingRepository.save(princessJsCourseBooking);
    }
}
