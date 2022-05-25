package com.prekes.web.prekesweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_log")
@Getter
@Setter
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String requestUrl;

    private String username;

    private String email;

    private String authorities;

    private long timeTaken;

    private String handler;

    private LocalDateTime timestamp;

    public ActivityLog() {
    }

}
