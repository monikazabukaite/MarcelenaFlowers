package com.prekes.web.prekesweb.service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;

@Service
public class ActivityLogService {


    public void log(String activity) throws IOException {
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
