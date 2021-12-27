package ma.wiebatouta.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/signup")
public class SignUpController {
	private final static String PATH_SIGNUP="client/signup";
	@GetMapping
	public ModelAndView getPageSignUp() {
		ModelAndView model = new ModelAndView(PATH_SIGNUP);
		return model;
	}
}
