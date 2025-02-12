package com.example.schedulemanagement.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

public class LoginFilter implements Filter {

    // 로그인 인증이 필요하지 않은 path
    private static final String[] WHITE_LIST = {"/", "/users/signup", "/users/login"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 다양한 기능을 사용하기 위해 다운 캐스팅
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 요청한 path를 반환
        String requestURI = httpRequest.getRequestURI();


        if(!isWhiteList(requestURI)){

            HttpSession session = httpRequest.getSession(false);

            if(session == null || session.getAttribute("login") == null) {
                throw new RuntimeException("로그인 해주세요.");
            }
        }
        // 다음 필터 호출
        chain.doFilter(request,response);

    }

    private boolean isWhiteList(String requestURI){
        return PatternMatchUtils.simpleMatch(WHITE_LIST,requestURI);
    }
}
