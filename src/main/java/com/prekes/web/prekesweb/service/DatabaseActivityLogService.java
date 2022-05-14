package com.prekes.web.prekesweb.service;

import com.prekes.web.prekesweb.model.ActivityLog;
import com.prekes.web.prekesweb.repository.ActivityLogRepository;
import com.prekes.web.prekesweb.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class DatabaseActivityLogService implements ActivityLogService{

    @Autowired
    private ActivityLogRepository activityLogRepository;

    public void log(String requestUrl, long timeTaken, UserDetailsImpl userDetails, Object handler) {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setRequestUrl(requestUrl);
        activityLog.setUsername(userDetails.getUsername());
        activityLog.setEmail(userDetails.getEmail());
        activityLog.setAuthorities(Objects.toString(userDetails.getAuthorities(), null));
        activityLog.setTimeTaken(timeTaken);
        activityLog.setHandler(Objects.toString(handler, null));
        activityLog.setTimestamp(LocalDateTime.now());

        activityLogRepository.save(activityLog);
    }
}
