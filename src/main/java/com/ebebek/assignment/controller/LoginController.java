package com.ebebek.assignment.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebebek.assignment.configuration.CustomUser;


@Controller
public class LoginController {

	
	@RequestMapping(value= {"/","login"},method=RequestMethod.GET)
	public String login(HttpServletRequest req, HttpServletResponse res,
			@RequestParam(value="error",required=false) String error,Model model) {
		if(null != error )	
			model.addAttribute("error", "username or password is incorrect");

		return "login";
	}
	
	@RequestMapping(value = {"loginOk" }, method = RequestMethod.GET)
	public String loginOk(ModelMap model,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirect
			) {
		CustomUser customUser =  (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(null != customUser ) {
			return "redirect:profile";
		}

		return "redirect:login";
	}
}
