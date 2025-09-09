package com.project.compusResurce_Automation_System;

import java.util.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    // In-memory login fail count by (id + name)
    private ConcurrentHashMap<String, AtomicInteger> attemptMap = new ConcurrentHashMap<>();
    
    
    

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam Long id, @RequestParam String username) {
        Map<String, Object> result = new HashMap<>();
        User user = userRepository.findById(id).orElse(null);
        if (user != null && user.getUsername().equals(username)) {
            attemptMap.remove(id + "_" + username);
            result.put("status", "success");
            result.put("role", user.getRole());
            result.put("id", user.getId());
            result.put("username", user.getUsername());
        } else {
            String key = id + "_" + username;
            attemptMap.putIfAbsent(key, new AtomicInteger(0));
            int count = attemptMap.get(key).incrementAndGet();
            result.put("status", "fail");
            result.put("count", count);
        }
        return result;
    }
    
    @GetMapping("/me")
    public Map<String, Object> getMe(@RequestParam Long id) {
        Map<String, Object> result = new HashMap<>();
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            result.put("id", user.getId());
            result.put("username", user.getUsername());
            result.put("role", user.getRole());
            return result;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Not logged in");
        }
    }

}
