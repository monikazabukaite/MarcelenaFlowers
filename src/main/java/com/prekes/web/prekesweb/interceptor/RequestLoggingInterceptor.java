package com.prekes.web.prekesweb.interceptor;

import com.prekes.web.prekesweb.security.services.UserDetailsImpl;
import com.prekes.web.prekesweb.service.DatabaseActivityLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.ArrayList;

@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingInterceptor.class);

    @Autowired
    private DatabaseActivityLogService activityLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = Instant.now().toEpochMilli();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = authentication.getPrincipal() instanceof UserDetailsImpl
                ? (UserDetailsImpl) authentication.getPrincipal()
                : new UserDetailsImpl(0L, "Guest", null, null, new ArrayList<>());

        String requestUrl = request.getRequestURL().toString().replaceFirst("^.*/{1}", "/");
        long timeTaken = Instant.now().toEpochMilli() - startTime;
        String activity = new StringBuilder()
                .append("Request URL = ").append(requestUrl)
                .append(" :: Time Taken = ").append(timeTaken).append("ms")
                .append(" :: User details = ").append(userDetails.toString())
                .append(" :: handler = ").append(handler).toString();

        logger.info(activity);
        activityLogService.log(requestUrl, timeTaken, userDetails, handler);
    }
}
