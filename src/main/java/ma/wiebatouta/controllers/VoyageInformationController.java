package ma.wiebatouta.controllers;

import java.util.List;
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

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Reservation;
import ma.wiebatouta.models.Voyage;
import ma.wiebatouta.repositories.ActiviteRepository;
import ma.wiebatouta.repositories.CountryRepository;
import ma.wiebatouta.repositories.EquipeRepository;
import ma.wiebatouta.repositories.PersonneRepository;
import ma.wiebatouta.repositories.ReservationRepository;
import ma.wiebatouta.repositories.ThemeRepository;
import ma.wiebatouta.repositories.VoyageRepository;

@Controller
@RequestMapping("myvoyage")
public class VoyageInformationController {
	
	private final static String PATH_SHOW_VOYAGE = "client/FicheVoyage";
	private final static String ATTRIBUT_AUTHENTIFICATED = "authentificated";
	private final static String ATTRIBUT_AUTHENTIFICATED_USERNAME = "username";
	private final static String ATTRIBUT_AUTHENTIFICATED_PERSON_ID = "idPerson";
	private final static String ATTRIBUT_RESERVATION_NUMBER = "reservationNumber";
	private final static String ATTRIBUT_VOYAGE = "voyage";

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
	
	@GetMapping("/{idVoyage}")
	public ModelAndView getMyVoyage(@PathVariable("idVoyage")Long id) throws NotFoundException {
		ModelAndView model = new ModelAndView(PATH_SHOW_VOYAGE);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Voyage voyage = voyageRepository.findById(id).orElseThrow(()->new NotFoundException("Voyage not found"));
		if (authentication instanceof AnonymousAuthenticationToken) {
			model.addObject(ATTRIBUT_VOYAGE,voyage);
			model.addObject(ATTRIBUT_AUTHENTIFICATED, false);
			
		} else {
			model.addObject(ATTRIBUT_VOYAGE,voyage);
			UserDetails userDetail = (UserDetails) authentication.getPrincipal();
			model.addObject(ATTRIBUT_AUTHENTIFICATED_USERNAME, userDetail.getUsername());
			model.addObject(ATTRIBUT_AUTHENTIFICATED, true);
			Personne personne = personneRepository.getPersonneFromUsername(userDetail.getUsername());
			System.out.println(personne);
			model.addObject(ATTRIBUT_AUTHENTIFICATED_PERSON_ID, personne.getId());
			List<Reservation> reservations = reservationRepository.findByPerson(personne);
			reservations = reservations.stream().filter(r -> !r.isConfirmed()).collect(Collectors.toList());
			model.addObject(ATTRIBUT_RESERVATION_NUMBER, reservations.size());
		}

		return model;
	}
	
}
