package com.project.compusResurce_Automation_System.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.compusResurce_Automation_System.Entities_Class.Grievance;
import com.project.compusResurce_Automation_System.Entities_Class.User;
import com.project.compusResurce_Automation_System.Repositories.GrievanceRepository;
import com.project.compusResurce_Automation_System.Repositories.UserRepository;

@RestController
@RequestMapping("/api/grievances")
public class GrievanceController {
	@Autowired
	private UserRepository userRepository;
	   @Autowired
	    private GrievanceRepository grievanceRepo;

	    public GrievanceController() {}

	    public GrievanceController(GrievanceRepository grievanceRepo) {
	        this.grievanceRepo = grievanceRepo;
	    }

	    @GetMapping
	    public List<Grievance> getAll() {
	        return grievanceRepo.findAll();
	    }

	    @PostMapping
	    public Grievance post(@RequestBody Grievance grievance) {
	        return grievanceRepo.save(grievance);
	    }
	  //for grievance status=view
	    @GetMapping("/grievance/{grievanceId}")
	    public Grievance viewGrievance(
	        @RequestParam Long userId, // teacher or admin
	        @PathVariable Long grievanceId
	    ) {
	        User user = userRepository.findById(userId).orElse(null);
	        if (user == null || 
	            !(user.getRole().equalsIgnoreCase("ADMIN") || user.getRole().equalsIgnoreCase("FACULTY"))) {
	            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
	        }

	        Grievance grievance = grievanceRepo.findById(grievanceId).orElse(null);
	        if (grievance == null) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grievance not found");
	        }

	        // Only update status if not already viewed/resolved
	        if (!"RESOLVED".equalsIgnoreCase(grievance.getStatus())) {
	            grievance.setStatus("VIEWED");
	            grievanceRepo.save(grievance);
	        }
	        return grievance;
	    }
	    //for grivenc status=solve
	    @PutMapping("/grievance/{grievanceId}/resolve")
	    public Grievance resolveGrievance(
	        @RequestParam Long userId, // teacher or admin
	        @PathVariable Long grievanceId
	    ) {
	        User user = userRepository.findById(userId).orElse(null);
	        if (user == null || 
	            !(user.getRole().equalsIgnoreCase("ADMIN") || user.getRole().equalsIgnoreCase("FACULTY"))) {
	            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
	        }

	        Grievance grievance = grievanceRepo.findById(grievanceId).orElse(null);
	        if (grievance == null) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grievance not found");
	        }

	        grievance.setStatus("RESOLVED SUCCESSFULLY");
	        grievanceRepo.save(grievance);
	        return grievance;
	    }

}
