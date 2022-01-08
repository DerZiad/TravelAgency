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
			model.addObject(ATTRIBUT_BEST_VOYAGE, sortedEquipes);
		}

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
	
	@GetMapping("{name}")
	public ModelAndView voyageParTheme(@PathVariable("name")String nomTheme) {
		System.out.println("ayman"+nomTheme);
		Theme theme = themeRepository.findByLabel(nomTheme);
		List<Voyage> voyages =theme.getVoyages();
		//System.out.println(":"+voyages);
		ModelAndView model = new ModelAndView(PATH_SHOW_VOYAGE);
		model.addObject("voyages", voyages);
		return model;
	}
}
