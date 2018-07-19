
package com.ebebek.assignment.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler{
	
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		request.setAttribute("param", "error");
		String exceptionNumber = ""; //login.jsp de excepiton numberına göre, açıklama eşleşmesi yapılıyor
		if(exception != null){
			exceptionNumber = exception.getMessage();
		}
		response.sendRedirect("/assignment/login?error="+exceptionNumber);
	}
}