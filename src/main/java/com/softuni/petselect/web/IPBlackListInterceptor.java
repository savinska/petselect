package com.softuni.petselect.web;

import com.softuni.petselect.service.BlackListService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.View;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import java.util.Locale;
import java.util.Map;

@Component
public class IPBlackListInterceptor implements HandlerInterceptor {

    private final BlackListService blackListService;
    private final ThymeleafViewResolver thymeleafViewResolver;

    public IPBlackListInterceptor(BlackListService blackListService, ThymeleafViewResolver thymeleafViewResolver) {
        this.blackListService = blackListService;
        this.thymeleafViewResolver = thymeleafViewResolver;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String ip = getIPFromRequest(request);

        if (blackListService.isBlackListed(ip)){
           View blockedView = thymeleafViewResolver.resolveViewName("blocked", Locale.getDefault());

           if (blockedView != null){
               blockedView.render(Map.of(),request,response);
           }
          return false;
        }
        return true;
    }

    private String getIPFromRequest(HttpServletRequest request){
        String xffHeader = request.getHeader("X-FORWARDER-FOR");

        String ipAddress = null;

        if (xffHeader != null && !xffHeader.equals("unknown")){

            int commaIdx = xffHeader.indexOf(",");

                    if(commaIdx > 0){
                        ipAddress = xffHeader.substring(0, commaIdx);

                    }
        }

        if(ipAddress == null){
            ipAddress = request.getRemoteAddr();
        }

    return ipAddress;
    }
}
