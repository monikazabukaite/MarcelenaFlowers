package com.prekes.web.prekesweb.interceptor;

import com.prekes.web.prekesweb.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        logger.info("Request URL::" + request.getRequestURL().toString() +
                ":: Time Taken = " + (Instant.now().toEpochMilli() - startTime) + "ms " +
                ":: User details " + userDetails.toString());
    }
}
