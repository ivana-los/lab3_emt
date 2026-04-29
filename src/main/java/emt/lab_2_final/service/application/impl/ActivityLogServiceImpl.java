package emt.lab_2_final.service.application.impl;


import emt.lab_2_final.model.ActivityLog;
import emt.lab_2_final.model.enums.EventType;
import emt.lab_2_final.repository.ActivityLogRepository;
import emt.lab_2_final.service.application.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    @Override
    public void log(String bookTitle, EventType eventType) {
        ActivityLog log = new ActivityLog(bookTitle, eventType);
        activityLogRepository.save(log);
    }

    @Override
    public Page<ActivityLog> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("eventTime").descending());
        return activityLogRepository.findAllByOrderByEventTimeDesc(pageable);
    }
}
