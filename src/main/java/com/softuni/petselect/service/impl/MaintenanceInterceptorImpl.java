package com.softuni.petselect.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalTime;

@Configuration
public class MaintenanceInterceptorImpl implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
                var requestURI = request.getRequestURI();
                if (!requestURI.equals("/maintenance")) {
                    LocalTime now = LocalTime.now();
                    if (now.getHour() >= 23) {
                        response.sendRedirect("/maintenance");
                        return false;
                    }
                }

                return HandlerInterceptor.super.preHandle(request, response, handler);
            }
    }
