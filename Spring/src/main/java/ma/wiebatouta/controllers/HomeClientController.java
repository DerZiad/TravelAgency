package ma.wiebatouta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeClientController {

	private final static String PATH_HOME_PAGE = "client/index";
	
	@GetMapping
	public ModelAndView getPrincipalPage() {
		ModelAndView model = new ModelAndView(PATH_HOME_PAGE);
		return model;
	}
}
