package com.springboot.app.models.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class admin {

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String listar(Model model) {	
		return "admin";
	}
	
}
