package com.ebebek.assignment.configuration;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler{
	@Value("${appContext:/library}")
	String appName;
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		request.setAttribute("param", "error");
		String exceptionNumber = "";
		if(null != exception){
			exceptionNumber = exception.getMessage();
		}
		response.sendRedirect("/assignment/login?error="+exceptionNumber);
	}
}