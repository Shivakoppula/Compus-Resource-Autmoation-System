package com.project.compusResurce_Automation_System.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.compusResurce_Automation_System.Entities_Class.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	  User findByUsername(String username);

	List<User> findByRoleIgnoreCase(String string);
}
