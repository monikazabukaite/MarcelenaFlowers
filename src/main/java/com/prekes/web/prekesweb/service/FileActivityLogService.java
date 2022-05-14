package com.prekes.web.prekesweb.service;

import com.prekes.web.prekesweb.security.services.UserDetailsImpl;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class FileActivityLogService implements ActivityLogService{

    public void log(String requestUrl, long timeTaken, UserDetailsImpl userDetails, Object handler) throws IOException {
        String activity = new StringBuilder()
                .append("Time = ").append(LocalDateTime.now())
                .append(" :: Request URL = ").append(requestUrl)
                .append(" :: Time Taken = ").append(timeTaken).append("ms")
                .append(" :: User details = ").append(userDetails.toString())
                .append(" :: handler = ").append(handler).toString();

        try (FileWriter myWriter = new FileWriter(getFileName(), true)) {
            myWriter.write(activity + "\n");
        }
    }

    private String getFileName() {
        StringBuilder sb = new StringBuilder(Paths.get(".").toAbsolutePath().normalize().toFile().toString())
                .append("\\tmp\\activityLog_")
                .append(LocalDate.now())
                .append(".txt");
        return sb.toString();
    }
}
