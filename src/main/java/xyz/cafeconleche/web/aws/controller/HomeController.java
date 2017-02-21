package xyz.cafeconleche.web.aws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private Environment environment;
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("puerto", environment.getProperty("server.port"));
		return mav;
	}

}
