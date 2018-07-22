package com.ebebek.assignment.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebebek.assignment.configuration.CustomUser;

@Controller
public class ProfilesController {

	
	@RequestMapping(value="profile",method=RequestMethod.GET)
	public String profile(HttpServletRequest req, HttpServletResponse res, Model model, Principal principal) {
		CustomUser customUser =  (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", customUser.getUser());
		return "profile";
	}
}
