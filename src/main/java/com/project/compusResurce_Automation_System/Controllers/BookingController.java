package com.project.compusResurce_Automation_System.Controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.compusResurce_Automation_System.Entities_Class.ClassroomBooking;
import com.project.compusResurce_Automation_System.Repositories.ClassroomBookingRepository;
import com.project.compusResurce_Automation_System.Services.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private ClassroomBookingRepository bookingRepo;

    public BookingController() {}

    public BookingController(BookingService bookingService, ClassroomBookingRepository bookingRepo) {
        this.bookingService = bookingService;
        this.bookingRepo = bookingRepo;
    }

    @GetMapping
    public List<ClassroomBooking> getAll() {
        return bookingRepo.findAll();
    }

    @PostMapping("/book")
    public ClassroomBooking book(@RequestBody ClassroomBooking booking) {
        return bookingService.bookRoom(booking);
    }

    @GetMapping("/available")
    public boolean isAvailable(@RequestParam String room,
                              @RequestParam String start,
                              @RequestParam String end) {
        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);
        return bookingService.isAvailable(room, startTime, endTime);
    }

}
