package com.project.compusResurce_Automation_System.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.compusResurce_Automation_System.Entities_Class.Notice;
import com.project.compusResurce_Automation_System.Repositories.NoticeRepository;

@Service
public class NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;

    public NoticeService() {}

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    public Optional<Notice> getNoticeById(Long id) {
        return noticeRepository.findById(id);
    }

    public Notice saveNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }
}
