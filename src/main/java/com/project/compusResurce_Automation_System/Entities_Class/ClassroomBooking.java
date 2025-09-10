package com.project.compusResurce_Automation_System.Entities_Class;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ClassroomBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String bookedBy;
	public ClassroomBooking(Long id, String roomNumber, LocalDateTime startTime, LocalDateTime endTime,
			String bookedBy) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.startTime = startTime;
		this.endTime = endTime;
		this.bookedBy = bookedBy;
	}
	public ClassroomBooking(String roomNumber, LocalDateTime startTime, LocalDateTime endTime, String bookedBy) {
		super();
		this.roomNumber = roomNumber;
		this.startTime = startTime;
		this.endTime = endTime;
		this.bookedBy = bookedBy;
	}
	public ClassroomBooking() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}
    


}
