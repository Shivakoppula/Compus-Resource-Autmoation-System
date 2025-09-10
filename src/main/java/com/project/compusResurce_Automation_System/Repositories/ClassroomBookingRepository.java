package com.project.compusResurce_Automation_System.Repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.compusResurce_Automation_System.Entities_Class.ClassroomBooking;
@Repository
public interface ClassroomBookingRepository extends JpaRepository<ClassroomBooking, Long> {
	 List<ClassroomBooking> findByRoomNumberAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
		        String roomNumber, LocalDateTime endTime, LocalDateTime startTime
		    );
}
