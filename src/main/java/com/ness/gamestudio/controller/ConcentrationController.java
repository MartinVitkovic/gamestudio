package com.ness.gamestudio.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ConcentrationController {
	
	@RequestMapping("/concentration")
	public String concentration() {
		return "concentration";
	}

}
