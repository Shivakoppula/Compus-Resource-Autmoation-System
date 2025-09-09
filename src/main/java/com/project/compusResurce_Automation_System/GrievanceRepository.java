package com.project.compusResurce_Automation_System;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GrievanceRepository extends JpaRepository<Grievance, Long> {

}
