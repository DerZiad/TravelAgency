package ma.wiebatouta.controllers;

import ma.wiebatouta.interfaces.DesignAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.repositories.HistoriqueRepository;

@Controller
@RequestMapping("/admin/historiques")
public class HistoriqueController {
	
	public final static String HISTORY_PATH = "admin/ListHistorique";



	@Autowired
	private HistoriqueRepository historiqueRepository;
	
	@GetMapping
	public ModelAndView getHistoriques() {
		ModelAndView model = new ModelAndView(HISTORY_PATH);
		model.addObject(DesignAttributes.ACTIVE_HISTORY,DesignAttributes.ACTIVE);
		model.addObject("historiques",historiqueRepository.findAll());
		return model;
	}
	
	@GetMapping("/vider")
	public ModelAndView viderHistorique() {
		historiqueRepository.deleteAll();
		return new ModelAndView("redirect:/admin/historiques");
	}
}
