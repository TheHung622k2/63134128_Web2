package jp.ivs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class WelcomeController {
	
	@RequestMapping("index")
	public String home() 
	{
		return "index";
	}
	
	@RequestMapping("about")
	public String about()
	{
		return "about";
	}
	
	@RequestMapping("contact")
	public String contact()
	{
		return "contact";
	}
	
	@RequestMapping("feedback")
	public String feedback()
	{
		return "feedback";
	}
	
	@RequestMapping("faq")
	public String faq()
	{
		return "faq";
	}
}
