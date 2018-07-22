package com.ebebek.assignment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebebek.assignment.customeditor.CustomInputEditor;
import com.ebebek.assignment.model.User;
import com.ebebek.assignment.services.CustomUserDetailsService;
import com.ebebek.assignment.services.RoleService;
import com.ebebek.assignment.services.UserService;

@Controller
public class RegisterController{

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	
	@InitBinder
	public void binder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new CustomInputEditor());
	}
	
	@ModelAttribute("user")
	public User prepare() {
		return new User();
	}
	
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String register(Model model) {
		
		return "register";
	}

	@RequestMapping(value="register",method=RequestMethod.POST)
	public String registerPost(@Valid @ModelAttribute("user") User user ,BindingResult result,RedirectAttributes redirect) {
		if(!result.hasErrors()) {
			userDetailsService.saveUser(user);
			redirect.addFlashAttribute("register","succsses");
			return "redirect:login";
		}
		return "register";
	}

	
}
