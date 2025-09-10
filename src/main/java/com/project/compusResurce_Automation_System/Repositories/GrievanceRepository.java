package com.project.compusResurce_Automation_System.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.compusResurce_Automation_System.Entities_Class.Grievance;
@Repository
public interface GrievanceRepository extends JpaRepository<Grievance, Long> {

}
