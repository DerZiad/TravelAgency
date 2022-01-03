package ma.wiebatouta.controllers;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.models.Country;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Reservation;
import ma.wiebatouta.models.Voyage;
import ma.wiebatouta.repositories.CountryRepository;
import ma.wiebatouta.repositories.PersonneRepository;
import ma.wiebatouta.repositories.ReservationRepository;
import ma.wiebatouta.repositories.VoyageHomeRepository;
import ma.wiebatouta.repositories.VoyageRepository;

@Controller
@RequestMapping("/search")
public class SearchController {

	private final static String PATH_SEARCH = "client/corps";
	private final static String REDIRECT_HP = "redirect:/";
	private final static String ATTRIBUT_AUTHENTIFICATED = "authentificated";
	private final static String ATTRIBUT_AUTHENTIFICATED_USERNAME = "username";
	private final static String ATTRIBUT_AUTHENTIFICATED_PERSON_ID = "idPerson";
	private final static String ATTRIBUT_RESERVATION_NUMBER = "reservationNumber";
	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private VoyageRepository voyageRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private VoyageHomeRepository voyageHomeRepository;
	@Autowired
	private ReservationRepository reservationRepository;

	// @DateTimeFormat(pattern = "yyyy-MM-dd") Date
	@GetMapping
	public ModelAndView search(@RequestParam(name = "country", required = false) String country,
			@RequestParam(name = "date_depart", required = false) String dateDepart,
			@RequestParam(name = "date_arrive", required = false) String dateArrive,
			@RequestParam(name = "budget", required = false) Double budget,
			@RequestParam(name = "nbrePersonne", required = false) String nbrPersonne,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
		ModelAndView model = new ModelAndView(PATH_SEARCH);
		
		if (country.equals("default")) {
			boolean b = true;
			Pageable pageInc = PageRequest.of(page, size);
			List<Country> countries = countryRepository.findAll();
			Page<Voyage> pages = voyageHomeRepository.findAll(pageInc);
			model.addObject("data", pages.getContent());
			model.addObject("number", pages.getNumber());
			model.addObject("totalPages", pages.getTotalPages());
			model.addObject("totalElements", pages.getTotalElements());
			model.addObject("size", pages.getSize());
			model.addObject("boolean", b);
			model.addObject("countries", countries);
			// return new ModelAndView(REDIRECT_HP);
		} else {
			int nbr;
			if (!nbrPersonne.equals("")) {
				nbr = Integer.parseInt(nbrPersonne);
			} else {
				nbr = 0;
			}
			boolean b = false;
			Date dd = Date.valueOf(dateDepart);
			Date da = Date.valueOf(dateArrive);
			List<Voyage> voyages = voyageRepository.getVoyageSearch(country, dd, da, budget, nbr);
			/*
			 * Page<Voyage> pages = voyageHomeRepository.findAll(pageable);
			 * model.addObject("trends", pages.getContent()); model.addObject("number",
			 * pages.getNumber()); model.addObject("totalPages", pages.getTotalPages());
			 * model.addObject("totalElements", pages.getTotalElements());
			 * model.addObject("size", pages.getSize());
			 */
			model.addObject("boolean", b);

			model.addObject("trends", voyages);
			// System.out.println("cas 1" + pages.getContent());
		}
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
		return model;
	}
}
