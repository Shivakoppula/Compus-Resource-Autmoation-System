package com.project.compusResurce_Automation_System.Controllers;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.compusResurce_Automation_System.Entities_Class.Grievance;
import com.project.compusResurce_Automation_System.Entities_Class.Notice;
import com.project.compusResurce_Automation_System.Entities_Class.User;
import com.project.compusResurce_Automation_System.Repositories.GrievanceRepository;
import com.project.compusResurce_Automation_System.Repositories.NoticeRepository;
import com.project.compusResurce_Automation_System.Repositories.UserRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GrievanceRepository grievanceRepository;
    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/admin-data")
    public Object getAdminData(@RequestParam Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null || !"ADMIN".equals(user.getRole())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        }
       
        return "This is protected admin data!";
    }
    
  

    // Helper: Checks if requester is admin
    private void checkIsAdmin(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null || !"ADMIN".equalsIgnoreCase(user.getRole())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        }
    }

    //Get all users
    @GetMapping("/users")
    public List<User> getAllUsers(@RequestParam Long adminId) {
        checkIsAdmin(adminId);
        return userRepository.findAll();
    }
    
    // Add a user
    @PostMapping("/user")
    public User addUser(@RequestParam Long adminId, @RequestBody User newUser) {
        checkIsAdmin(adminId);
        return userRepository.save(newUser);
    }

    //Delete a user
    @DeleteMapping("/user/{userId}")
    public String deleteUser(@RequestParam Long adminId, @PathVariable Long userId) {
        checkIsAdmin(adminId);
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        if ("ADMIN".equalsIgnoreCase(user.getRole())) throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Cannot delete another admin");
        userRepository.deleteById(userId);
        return "User deleted successfully";
    }

    // Get system statistics
    @GetMapping("/stats")
    public Map<String, Object> getSystemStats(@RequestParam Long adminId) {
        checkIsAdmin(adminId);
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalUsers", userRepository.count());
        stats.put("totalStudents", userRepository.findByRoleIgnoreCase("STUDENT").size());
        stats.put("totalTeachers", userRepository.findByRoleIgnoreCase("FACULTY").size());
        stats.put("totalAdmins", userRepository.findByRoleIgnoreCase("ADMIN").size());
        stats.put("totalGrievances", grievanceRepository.count());
        stats.put("totalNotices", noticeRepository.count());
        return stats;
    }

    //Get all grievances
    @GetMapping("/grievances")
    public List<Grievance> getAllGrievances(@RequestParam Long adminId) {
        checkIsAdmin(adminId);
        return grievanceRepository.findAll();
    }

    //  Get all notices
    @GetMapping("/notices")
    public List<Notice> getAllNotices(@RequestParam Long adminId) {
        checkIsAdmin(adminId);
        return noticeRepository.findAll();
    }

    // Create a notice
    @PostMapping("/notice")
    public Notice createNotice(@RequestParam Long adminId, @RequestBody Notice notice) {
        checkIsAdmin(adminId);
        return noticeRepository.save(notice);
    }
    //delete a notice
    @DeleteMapping("/notice/{noticeId}")
    public String deleteNotice(@RequestParam Long adminId, @PathVariable Long noticeId) {
        checkIsAdmin(adminId);
        Notice notice = noticeRepository.findById(noticeId).orElse(null);
        if (notice == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notice not found");
        }
        noticeRepository.deleteById(noticeId);
        return "Notice deleted successfully";
    }


}
