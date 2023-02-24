package ma.wiebatouta.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.models.Activite;
import ma.wiebatouta.models.Country;
import ma.wiebatouta.models.Equipe;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Reservation;
import ma.wiebatouta.models.Theme;
import ma.wiebatouta.models.Voyage;
import ma.wiebatouta.repositories.ActiviteRepository;
import ma.wiebatouta.repositories.CountryRepository;
import ma.wiebatouta.repositories.EquipeRepository;
import ma.wiebatouta.repositories.PersonneRepository;
import ma.wiebatouta.repositories.ReservationRepository;
import ma.wiebatouta.repositories.ThemeRepository;
import ma.wiebatouta.repositories.VoyageRepository;

@Controller
@RequestMapping("/")
public class HomeClientController {

	private final static String PATH_HOME_PAGE = "client/corps";
	private final static String PATH_SHOW_VOYAGE = "client/FicheVoyage";
	private final static String ATTRIBUT_BEST_VOYAGE = "voyagesBest";
	private final static String ATTRIBUT_BEST_EQUIPE = "equipesBest";
	private final static String ATTRIBUT_BEST_VOYAGE_REDUCTION = "voyageReduction";
	private final static String ATTRIBUT_AUTHENTIFICATED = "authentificated";
	private final static String ATTRIBUT_AUTHENTIFICATED_USERNAME = "username";
	private final static String ATTRIBUT_AUTHENTIFICATED_PERSON_ID = "idPerson";
	private final static String ATTRIBUT_RESERVATION_NUMBER = "reservationNumber";
	private final static String ATTRIBUT_COUNTRIES = "countries";
	private final static String ATTRIBUT_VOYAGES_TRENDS = "trends";
	
	
	private final static String ATTRIBUT_VOYAGE_FINLAND="Finland";
	private final static String ATTRIBUT_VOYAGE_AUSTRALIA="Australia";
	private final static String ATTRIBUT_VOYAGE_NETHARLAND="Netherlands";
	private final static String ATTRIBUT_VOYAGE_BRAZIL="Brazil";
	private final static String ATTRIBUT_VOYAGE_TURKEY="Turkey";
	private final static String ATTRIBUT_VOYAGE_CHINA="China";
	
	private int nombreVoyagesBest = 6;
	private int nombreEquipeBest = 9;
	@Autowired
	private VoyageRepository voyageRepository;

	@Autowired
	private EquipeRepository equipeRepository;

	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ActiviteRepository activiteRepository;
	@Autowired
	private ThemeRepository themeRepository;
	
	
	
	
	
	@SuppressWarnings("deprecation")
	@GetMapping
	public ModelAndView getPrincipalPage() {
		ModelAndView model = new ModelAndView(PATH_HOME_PAGE);

		/**
		 * Selecting voyage
		 */
		List<Voyage> voyages = voyageRepository.findAll();
		Collections.sort(voyages);
		if (voyages.size() < nombreVoyagesBest) {
			model.addObject(ATTRIBUT_BEST_VOYAGE, voyages);
		} else {
			List<Voyage> sortedVoyages = new ArrayList<Voyage>();
			for (int i = 0; i < nombreVoyagesBest; i++) {
				sortedVoyages.add(voyages.get(i));

			}
			model.addObject(ATTRIBUT_BEST_VOYAGE, sortedVoyages);
		}

		/**
		 * Voyages reduction
		 **/
		List<Voyage> voyagesReduction = new ArrayList<Voyage>();
		for (Voyage voyage : voyages) {
			if (voyage.isSolded()) {
				voyagesReduction.add(voyage);
			}
		}
		if (voyagesReduction.size() != 0) {
			Random random = new Random();
			int indice = random.nextInt(voyagesReduction.size());
			model.addObject(ATTRIBUT_BEST_VOYAGE_REDUCTION, voyagesReduction.get(indice));
			model.addObject("timelong", voyagesReduction.get(indice).getDateDepart().toGMTString());
		}

		/**
		 * Selecting equipe
		 */
		List<Equipe> equipes = equipeRepository.findAll();
		Collections.sort(equipes);
		if (voyages.size() < nombreEquipeBest) {
			model.addObject(ATTRIBUT_BEST_EQUIPE, equipes);
		} else {
			List<Equipe> sortedEquipes = new ArrayList<Equipe>();
			for (int i = 0; i < nombreEquipeBest; i++) {
				sortedEquipes.add(equipes.get(i));

			}
			model.addObject(ATTRIBUT_BEST_EQUIPE, sortedEquipes);
		}
		
		
		/**
		 * 
		 * Selecting special offers
		 * **/
		
		List<Voyage> voyagesVenuzuala = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_FINLAND);
		List<Voyage> voyagesAustralia = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_AUSTRALIA);
		List<Voyage> voyagesNetherLand = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_NETHARLAND);
		List<Voyage> voyagesBrazil = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_BRAZIL);
		List<Voyage> voyagesTurkey = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_TURKEY);
		List<Voyage> voyagesChina = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_CHINA);
		
		model.addObject(ATTRIBUT_VOYAGE_FINLAND,voyagesVenuzuala.size());
		model.addObject(ATTRIBUT_VOYAGE_AUSTRALIA,voyagesAustralia.size());
		model.addObject(ATTRIBUT_VOYAGE_NETHARLAND,voyagesNetherLand.size());
		model.addObject(ATTRIBUT_VOYAGE_BRAZIL,voyagesBrazil.size());
		model.addObject(ATTRIBUT_VOYAGE_TURKEY,voyagesTurkey.size());
		model.addObject(ATTRIBUT_VOYAGE_CHINA,voyagesChina.size());

		/**
		 * Authentication
		 **/
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof AnonymousAuthenticationToken) {
			model.addObject(ATTRIBUT_AUTHENTIFICATED, false);
		} else {
			UserDetails userDetail = (UserDetails) authentication.getPrincipal();
			model.addObject(ATTRIBUT_AUTHENTIFICATED_USERNAME, userDetail.getUsername());
			model.addObject(ATTRIBUT_AUTHENTIFICATED, true);
			Personne personne = personneRepository.getPersonneFromUsername(userDetail.getUsername());
			model.addObject(ATTRIBUT_AUTHENTIFICATED_PERSON_ID, personne.getId());
			List<Reservation> reservations = reservationRepository.findByPerson(personne);
			reservations = reservations.stream().filter(r -> !r.isConfirmed()).collect(Collectors.toList());
			model.addObject(ATTRIBUT_RESERVATION_NUMBER, reservations.size());
		}

		/**
		 * Countries
		 **/
		model.addObject(ATTRIBUT_COUNTRIES, countryRepository.findAll());

		/**
		 * Trends
		 */
		List<Voyage> voyagesTrend = voyageRepository.findAll();
		Collections.sort(voyagesTrend);
		List<Voyage> trends = new ArrayList<Voyage>();
		if (voyagesTrend.size() < 3) {
			trends = voyagesTrend;
		} else {
			trends.add(voyagesTrend.get(0));
			trends.add(voyagesTrend.get(1));
			trends.add(voyagesTrend.get(2));
		}
		model.addObject(ATTRIBUT_VOYAGES_TRENDS, trends);
		return model;
	}
	
	@GetMapping("theme/{name}")
	public ModelAndView voyageParTheme(@PathVariable("name")String nomTheme) {
		ModelAndView model = new ModelAndView(PATH_HOME_PAGE);
		Theme theme = themeRepository.findByLabel(nomTheme);
		System.out.println("theme"+theme);
		List<Voyage> voyages =theme.getVoyages();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof AnonymousAuthenticationToken) {
			model.addObject(ATTRIBUT_AUTHENTIFICATED, false);
			List<Voyage> voyagesVenuzuala = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_FINLAND);
			List<Voyage> voyagesAustralia = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_AUSTRALIA);
			List<Voyage> voyagesNetherLand = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_NETHARLAND);
			List<Voyage> voyagesBrazil = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_BRAZIL);
			List<Voyage> voyagesTurkey = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_TURKEY);
			List<Voyage> voyagesChina = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_CHINA);
			
			model.addObject(ATTRIBUT_VOYAGE_FINLAND,voyagesVenuzuala.size());
			model.addObject(ATTRIBUT_VOYAGE_AUSTRALIA,voyagesAustralia.size());
			model.addObject(ATTRIBUT_VOYAGE_NETHARLAND,voyagesNetherLand.size());
			model.addObject(ATTRIBUT_VOYAGE_BRAZIL,voyagesBrazil.size());
			model.addObject(ATTRIBUT_VOYAGE_TURKEY,voyagesTurkey.size());
			model.addObject(ATTRIBUT_VOYAGE_CHINA,voyagesChina.size());
		} else {
			UserDetails userDetail = (UserDetails) authentication.getPrincipal();
			List<Voyage> voyagesVenuzuala = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_FINLAND);
			List<Voyage> voyagesAustralia = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_AUSTRALIA);
			List<Voyage> voyagesNetherLand = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_NETHARLAND);
			List<Voyage> voyagesBrazil = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_BRAZIL);
			List<Voyage> voyagesTurkey = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_TURKEY);
			List<Voyage> voyagesChina = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_CHINA);
			
			model.addObject(ATTRIBUT_VOYAGE_FINLAND,voyagesVenuzuala.size());
			model.addObject(ATTRIBUT_VOYAGE_AUSTRALIA,voyagesAustralia.size());
			model.addObject(ATTRIBUT_VOYAGE_NETHARLAND,voyagesNetherLand.size());
			model.addObject(ATTRIBUT_VOYAGE_BRAZIL,voyagesBrazil.size());
			model.addObject(ATTRIBUT_VOYAGE_TURKEY,voyagesTurkey.size());
			model.addObject(ATTRIBUT_VOYAGE_CHINA,voyagesChina.size());
			model.addObject(ATTRIBUT_AUTHENTIFICATED_USERNAME, userDetail.getUsername());
			model.addObject(ATTRIBUT_AUTHENTIFICATED, true);
			Personne personne = personneRepository.getPersonneFromUsername(userDetail.getUsername());
			model.addObject(ATTRIBUT_AUTHENTIFICATED_PERSON_ID, personne.getId());
			List<Reservation> reservations = reservationRepository.findByPerson(personne);
			reservations = reservations.stream().filter(r -> !r.isConfirmed()).collect(Collectors.toList());
			model.addObject(ATTRIBUT_RESERVATION_NUMBER, reservations.size());
		}
		//System.out.println(":"+voyages);
		/**
		 * Selecting equipe
		 */
		List<Equipe> equipes = equipeRepository.findAll();
		Collections.sort(equipes);
		if (voyages.size() < nombreEquipeBest) {
			model.addObject(ATTRIBUT_BEST_EQUIPE, equipes);
		} else {
			List<Equipe> sortedEquipes = new ArrayList<Equipe>();
			for (int i = 0; i < nombreEquipeBest; i++) {
				sortedEquipes.add(equipes.get(i));

			}
			model.addObject(ATTRIBUT_BEST_EQUIPE, sortedEquipes);
		}
		/**
		 * Voyages reduction
		 **/
		List<Voyage> voyagesReduction = new ArrayList<Voyage>();
		for (Voyage voyage : voyages) {
			if (voyage.isSolded()) {
				voyagesReduction.add(voyage);
			}
		}
		if (voyagesReduction.size() != 0) {
			Random random = new Random();
			int indice = random.nextInt(voyagesReduction.size());
			model.addObject(ATTRIBUT_BEST_VOYAGE_REDUCTION, voyagesReduction.get(indice));
			model.addObject("timelong", voyagesReduction.get(indice).getDateDepart().toGMTString());
		}

		model.addObject(ATTRIBUT_BEST_VOYAGE, voyages);
		model.addObject("theme", nomTheme);
		List<Country> countries = countryRepository.findAll();
		model.addObject(ATTRIBUT_COUNTRIES, countries);
		return model;
	}

	@GetMapping("/destination/{name}")
	public ModelAndView voyageParDestination(@PathVariable("name")String destination) {
		ModelAndView model = new ModelAndView(PATH_HOME_PAGE);
		/*Theme theme = themeRepository.findByDestination*/
		List<Voyage> voyages =voyageRepository.findByDestination(destination);		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof AnonymousAuthenticationToken) {
			model.addObject(ATTRIBUT_AUTHENTIFICATED, false);
			List<Voyage> voyagesVenuzuala = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_FINLAND);
			List<Voyage> voyagesAustralia = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_AUSTRALIA);
			List<Voyage> voyagesNetherLand = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_NETHARLAND);
			List<Voyage> voyagesBrazil = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_BRAZIL);
			List<Voyage> voyagesTurkey = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_TURKEY);
			List<Voyage> voyagesChina = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_CHINA);
			
			model.addObject(ATTRIBUT_VOYAGE_FINLAND,voyagesVenuzuala.size());
			model.addObject(ATTRIBUT_VOYAGE_AUSTRALIA,voyagesAustralia.size());
			model.addObject(ATTRIBUT_VOYAGE_NETHARLAND,voyagesNetherLand.size());
			model.addObject(ATTRIBUT_VOYAGE_BRAZIL,voyagesBrazil.size());
			model.addObject(ATTRIBUT_VOYAGE_TURKEY,voyagesTurkey.size());
			model.addObject(ATTRIBUT_VOYAGE_CHINA,voyagesChina.size());
		} else {
			List<Voyage> voyagesVenuzuala = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_FINLAND);
			List<Voyage> voyagesAustralia = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_AUSTRALIA);
			List<Voyage> voyagesNetherLand = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_NETHARLAND);
			List<Voyage> voyagesBrazil = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_BRAZIL);
			List<Voyage> voyagesTurkey = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_TURKEY);
			List<Voyage> voyagesChina = voyageRepository.getVoyageSearch(ATTRIBUT_VOYAGE_CHINA);
			
			model.addObject(ATTRIBUT_VOYAGE_FINLAND,voyagesVenuzuala.size());
			model.addObject(ATTRIBUT_VOYAGE_AUSTRALIA,voyagesAustralia.size());
			model.addObject(ATTRIBUT_VOYAGE_NETHARLAND,voyagesNetherLand.size());
			model.addObject(ATTRIBUT_VOYAGE_BRAZIL,voyagesBrazil.size());
			model.addObject(ATTRIBUT_VOYAGE_TURKEY,voyagesTurkey.size());
			model.addObject(ATTRIBUT_VOYAGE_CHINA,voyagesChina.size());
			UserDetails userDetail = (UserDetails) authentication.getPrincipal();
			model.addObject(ATTRIBUT_AUTHENTIFICATED_USERNAME, userDetail.getUsername());
			model.addObject(ATTRIBUT_AUTHENTIFICATED, true);
			Personne personne = personneRepository.getPersonneFromUsername(userDetail.getUsername());
			model.addObject(ATTRIBUT_AUTHENTIFICATED_PERSON_ID, personne.getId());
			List<Reservation> reservations = reservationRepository.findByPerson(personne);
			reservations = reservations.stream().filter(r -> !r.isConfirmed()).collect(Collectors.toList());
			model.addObject(ATTRIBUT_RESERVATION_NUMBER, reservations.size());
		}
		//System.out.println(":"+voyages);
		/**
		 * Selecting equipe
		 */
		List<Equipe> equipes = equipeRepository.findAll();
		Collections.sort(equipes);
		if (voyages.size() < nombreEquipeBest) {
			model.addObject(ATTRIBUT_BEST_EQUIPE, equipes);
		} else {
			List<Equipe> sortedEquipes = new ArrayList<Equipe>();
			for (int i = 0; i < nombreEquipeBest; i++) {
				sortedEquipes.add(equipes.get(i));

			}
			model.addObject(ATTRIBUT_BEST_EQUIPE, sortedEquipes);
		}
		/**
		 * Voyages reduction
		 **/
		List<Voyage> voyagesReduction = new ArrayList<Voyage>();
		for (Voyage voyage : voyages) {
			if (voyage.isSolded()) {
				voyagesReduction.add(voyage);
			}
		}
		if (voyagesReduction.size() != 0) {
			Random random = new Random();
			int indice = random.nextInt(voyagesReduction.size());
			model.addObject(ATTRIBUT_BEST_VOYAGE_REDUCTION, voyagesReduction.get(indice));
			model.addObject("timelong", voyagesReduction.get(indice).getDateDepart().toGMTString());
		}

		model.addObject(ATTRIBUT_BEST_VOYAGE, voyages);
		List<Country> countries = countryRepository.findAll();
		model.addObject(ATTRIBUT_COUNTRIES, countries);
		return model;
	}
}
