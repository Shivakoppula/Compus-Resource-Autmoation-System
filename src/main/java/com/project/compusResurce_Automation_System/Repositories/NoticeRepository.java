package com.project.compusResurce_Automation_System.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.compusResurce_Automation_System.Entities_Class.Notice;
@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
