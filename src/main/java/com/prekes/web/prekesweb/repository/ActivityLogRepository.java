package com.prekes.web.prekesweb.repository;

import com.prekes.web.prekesweb.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Integer> {
}
