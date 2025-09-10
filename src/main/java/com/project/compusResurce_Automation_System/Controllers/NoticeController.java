package com.project.compusResurce_Automation_System.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.compusResurce_Automation_System.Entities_Class.Notice;
import com.project.compusResurce_Automation_System.Repositories.NoticeRepository;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {
    @Autowired
    private NoticeRepository noticeRepo;

    public NoticeController() {}

    public NoticeController(NoticeRepository noticeRepo) {
        this.noticeRepo = noticeRepo;
    }

    @GetMapping
    public List<Notice> getAll() {
        return noticeRepo.findAll();
    }

    @PostMapping
    public Notice post(@RequestBody Notice notice) {
        return noticeRepo.save(notice);
    }

}
