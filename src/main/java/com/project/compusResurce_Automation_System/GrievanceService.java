package com.project.compusResurce_Automation_System;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrievanceService {
	   @Autowired
	    private GrievanceRepository grievanceRepository;

	    public GrievanceService() {}

	    public GrievanceService(GrievanceRepository grievanceRepository) {
	        this.grievanceRepository = grievanceRepository;
	    }

	    public List<Grievance> getAllGrievances() {
	        return grievanceRepository.findAll();
	    }

	    public Optional<Grievance> getGrievanceById(Long id) {
	        return grievanceRepository.findById(id);
	    }

	    public Grievance saveGrievance(Grievance grievance) {
	        return grievanceRepository.save(grievance);
	    }

	    public void deleteGrievance(Long id) {
	        grievanceRepository.deleteById(id);
	    }

}
