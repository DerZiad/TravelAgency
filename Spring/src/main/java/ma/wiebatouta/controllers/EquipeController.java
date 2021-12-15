package ma.wiebatouta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/ressources")
public class EquipeController {
	
	private final static String PAGE_AJOUT_EQUIPE="ressourcehumaines/ressourcehumaines";
	
	@GetMapping
	public ModelAndView getRessources() {
		ModelAndView model = new ModelAndView(PAGE_AJOUT_EQUIPE);
		System.out.println("Take");
		return model;
	}
}
