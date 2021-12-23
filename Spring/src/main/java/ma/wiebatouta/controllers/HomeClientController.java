package ma.wiebatouta.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.models.Equipe;
import ma.wiebatouta.models.User;
import ma.wiebatouta.models.Voyage;
import ma.wiebatouta.repositories.EquipeRepository;
import ma.wiebatouta.repositories.PersonneRepository;
import ma.wiebatouta.repositories.UserRepository;
import ma.wiebatouta.repositories.VoyageRepository;

@Controller
@RequestMapping("/")
public class HomeClientController {

	private final static String PATH_HOME_PAGE = "client/corps";
	private final static String ATTRIBUT_BEST_VOYAGE = "voyagesBest";
	private final static String ATTRIBUT_BEST_EQUIPE = "equipesBest";
	private final static String ATTRIBUT_BEST_VOYAGE_REDUCTION = "voyageReduction";
	private final static String ATTRIBUT_AUTHENTIFICATED = "authentificated";
	private final static String ATTRIBUT_AUTHENTIFICATED_USERNAME = "username";
	private final static String ATTRIBUT_AUTHENTIFICATED_PERSON_ID = "idPerson";
	private int nombreVoyagesBest = 6;
	private int nombreEquipeBest = 9;
	@Autowired
	private VoyageRepository voyageRepository;
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PersonneRepository personneRepository;
	
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
		
		/**
		 * Voyages reduction
		 * **/
		List<Voyage> voyagesReduction = new ArrayList<Voyage>();
		for(Voyage voyage:voyages) {
			if(voyage.isSolded()) {
				voyagesReduction.add(voyage);
			}
		}
		if(voyagesReduction.size() != 0) {
			Random random = new Random();
			int indice = random.nextInt(voyagesReduction.size());
			model.addObject(ATTRIBUT_BEST_VOYAGE_REDUCTION,voyagesReduction.get(indice));
			model.addObject("timelong",voyagesReduction.get(indice).getDateDepart().toGMTString());
		}
		
		/**
		 * Selecting equipe
		 * */
		List<Equipe> equipes = equipeRepository.findAll();
		Collections.sort(equipes);
		if(voyages.size() < nombreEquipeBest) {
			model.addObject(ATTRIBUT_BEST_EQUIPE,equipes);
		}else {
			List<Equipe> sortedEquipes = new ArrayList<Equipe>();
			for (int i = 0; i < nombreEquipeBest; i++) {
				sortedEquipes.add(equipes.get(i));
				
			}
			model.addObject(ATTRIBUT_BEST_VOYAGE,sortedEquipes);
		}
		
		/**
		 * Authentication
		 * **/
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication instanceof AnonymousAuthenticationToken) {
			model.addObject(ATTRIBUT_AUTHENTIFICATED,false);
		}else {
			UserDetails userDetail = (UserDetails)authentication.getPrincipal();
			model.addObject(ATTRIBUT_AUTHENTIFICATED_USERNAME,userDetail.getUsername());
			model.addObject(ATTRIBUT_AUTHENTIFICATED,true);
			model.addObject(ATTRIBUT_AUTHENTIFICATED_PERSON_ID,personneRepository.getPersonneFromUsername(userDetail.getUsername()).getId());
		}
		
		return model;
	}
	
}
