package emt.lab_2_final.service.application;

import emt.lab_2_final.model.ActivityLog;
import emt.lab_2_final.model.enums.EventType;
import org.springframework.data.domain.Page;

public interface ActivityLogService {
    void log(String bookTitle, EventType eventType);
    Page<ActivityLog> findAll(int page, int size);
}