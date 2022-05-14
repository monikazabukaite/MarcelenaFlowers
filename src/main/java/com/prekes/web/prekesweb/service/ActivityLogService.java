package com.prekes.web.prekesweb.service;

import com.prekes.web.prekesweb.security.services.UserDetailsImpl;

import java.io.IOException;

public interface ActivityLogService {

    void log(String requestUrl, long timeTaken, UserDetailsImpl userDetails, Object handler) throws IOException;
}
