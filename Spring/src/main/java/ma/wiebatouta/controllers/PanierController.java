package ma.wiebatouta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PanierController {

	private static final String PATH_PANIER = "client/panier";
	
	@GetMapping("/panier")
	public ModelAndView getPanier() {
		return new ModelAndView(PATH_PANIER);
	}
}
