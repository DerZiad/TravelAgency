package ma.wiebatouta.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.models.Voyage;
import ma.wiebatouta.repositories.VoyageRepository;

@Controller
@RequestMapping("/search")
public class SearchController {

	private final static String PATH_SEARCH = "client/corps";

	@Autowired
	private VoyageRepository voyageRepository;

	@PostMapping
	public ModelAndView search(@RequestParam(name = "country", required = false) String country,
			@RequestParam(name = "date_depart", required = false) @DateTimeFormat(pattern = "dd.MM.yyyy") Date dateDepart,
			@RequestParam(name = "date_arrive", required = false) @DateTimeFormat(pattern = "dd.MM.yyyy") Date dateArrive,
			@RequestParam(name = "budget", required = false) Double budget,
			@RequestParam(name = "nbrePersonne", required = false) String nbrPersonne) {
		ModelAndView model = new ModelAndView(PATH_SEARCH);
		System.out.println("COUNTRY ==> "+country);
		if (country.equals("default")) {
			List<Voyage> voyages = voyageRepository.findAll();
			model.addObject("voyages", voyages);
			System.out.println("cas 0" + voyages);
		} else {
			int nbr = Integer.parseInt(nbrPersonne);
			List<Voyage> voyages = voyageRepository.getVoyageSearch(country, dateDepart, dateArrive, budget,
					nbr);
			model.addObject("voyages", voyages);
			System.out.println("cas 1" + voyages);
		}

		return model;
	}
}
