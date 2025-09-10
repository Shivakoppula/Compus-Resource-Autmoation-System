package com.project.compusResurce_Automation_System.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.compusResurce_Automation_System.Entities_Class.ClassroomBooking;
import com.project.compusResurce_Automation_System.Repositories.ClassroomBookingRepository;

@Service
public class BookingService {
    @Autowired
    private ClassroomBookingRepository bookingRepo;

    public BookingService() {}

    public BookingService(ClassroomBookingRepository bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public boolean isAvailable(String room, LocalDateTime start, LocalDateTime end) {
        List<ClassroomBooking> conflicts = bookingRepo
            .findByRoomNumberAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(room, end, start);
        return conflicts.isEmpty();
    }

    public ClassroomBooking bookRoom(ClassroomBooking booking) {
        if (isAvailable(booking.getRoomNumber(), booking.getStartTime(), booking.getEndTime())) {
            return bookingRepo.save(booking);
        }
        throw new RuntimeException("Booking conflict detected!");
    }

}
