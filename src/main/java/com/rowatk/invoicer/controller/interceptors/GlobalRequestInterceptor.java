package com.rowatk.invoicer.controller.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalRequestInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = LoggerFactory.getLogger(GlobalRequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Request made: " + request.getPathInfo() + " " + request.getRequestURI() + " " + request.getContextPath());
        return super.preHandle(request, response, handler);
    }
}
