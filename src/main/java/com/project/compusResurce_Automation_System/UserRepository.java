package com.project.compusResurce_Automation_System;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	  User findByUsername(String username);

	List<User> findByRoleIgnoreCase(String string);
}
