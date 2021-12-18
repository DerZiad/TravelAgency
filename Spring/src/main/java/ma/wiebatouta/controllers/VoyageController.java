package ma.wiebatouta.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin/voyage")
public class VoyageController {

	private final static String PATH_INDEX_VOYAGE = "Voyage/index";
	
	@GetMapping
	public ModelAndView getPageIndexVoyage() {
		return new ModelAndView(PATH_INDEX_VOYAGE);
	}
}
