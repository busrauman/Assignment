package com.ebebek.assignment.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication)  
			throws IOException, ServletException {  
    
        HttpSession session = httpServletRequest.getSession();  
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);  
        httpServletResponse.sendRedirect("/assignment/loginOk");  
    }  
}