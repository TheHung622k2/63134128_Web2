package jp.ivs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping("/home")
	public String home() 
	{
		return "home";
	}
	
	@RequestMapping("/about")
	public String about()
	{
		return "about";
	}
}
