package com.project.compusResurce_Automation_System;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClassroomBookingRepository extends JpaRepository<ClassroomBooking, Long> {
	 List<ClassroomBooking> findByRoomNumberAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
		        String roomNumber, LocalDateTime endTime, LocalDateTime startTime
		    );
}
