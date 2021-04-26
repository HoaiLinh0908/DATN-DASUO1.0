package com.dasuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DasuoController {
	@RequestMapping("/index")
	public String demo() {
		return "index";
	}
	@RequestMapping("/login")
	public String Login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String signUp() {
		return "web/register";
	}
	
	@RequestMapping("/admin")
	public String HomeAdmin() {
		return "admin/homeadmin";
	}
	
	@RequestMapping("/city")
	public String viewCity() {
		return "web/addcity";
	}
	
	@RequestMapping("/account/userprofile")
	public String viewProfile() {
		return "web/userinformation";
	}

}
