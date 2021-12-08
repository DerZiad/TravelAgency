package ma.wiebatouta.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

	private static final String PATH_ADMIN_LOGIN = "login";

	private static final String ATTRIBUT_ERROR = "error";
	private static final String REDIRECT_ADMIN_SPACE = "redirect:/admin/";

	@GetMapping("/admin/login")
	public ModelAndView getPageLoginAdmin(HttpServletRequest request) {
		ModelAndView model = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			model = new ModelAndView(REDIRECT_ADMIN_SPACE);
		} else {
			model = new ModelAndView(PATH_ADMIN_LOGIN);
			String err = request.getParameter(ATTRIBUT_ERROR);
			if (err != null && err.equals("true")) {
				model.addObject(ATTRIBUT_ERROR, "Vos identifiants sont incorrects.");
			}
		}
		return model;
	}
}
