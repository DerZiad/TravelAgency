package ma.wiebatouta.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.models.Voyage;
import ma.wiebatouta.repositories.VoyageRepository;

@Controller
@RequestMapping("/")
public class HomeClientController {

	private final static String PATH_HOME_PAGE = "client/index";
	private final static String ATTRIBUT_BEST_VOYAGE = "voyagesBest";
	
	private int nombreVoyagesBest = 6;
	
	@Autowired
	private VoyageRepository voyageRepository;
	
	@GetMapping
	public ModelAndView getPrincipalPage() {
		ModelAndView model = new ModelAndView(PATH_HOME_PAGE);
		
		/**
		 * Selecting voyage
		 * */
		List<Voyage> voyages = voyageRepository.findAll();
		Collections.sort(voyages);
		if(voyages.size() < nombreVoyagesBest) {
			model.addObject(ATTRIBUT_BEST_VOYAGE,voyages);
		}else {
			List<Voyage> sortedVoyages = new ArrayList<Voyage>();
			for (int i = 0; i < nombreVoyagesBest; i++) {
				sortedVoyages.add(voyages.get(i));
				
			}
			model.addObject(ATTRIBUT_BEST_VOYAGE,sortedVoyages);
		}
		
		
		return model;
	}
}
