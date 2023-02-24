package ma.wiebatouta.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.models.Equipe;
import ma.wiebatouta.models.Hotel;
import ma.wiebatouta.models.Reservation;
import ma.wiebatouta.models.Voyage;
import ma.wiebatouta.repositories.EquipeRepository;
import ma.wiebatouta.repositories.HotelRepository;
import ma.wiebatouta.repositories.ReservationRepository;
import ma.wiebatouta.repositories.VoyageRepository;

@Controller
public class AuthenticationController {

	@Autowired
	private VoyageRepository voyageRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private EquipeRepository equipeRepository;

	private static final String ATTRIBUT_HOTELS_NUMBER = "hotelsnumber";
	private static final String ATTRIBUT_RESERVATIONS_NUMBER = "reservationsnumber";
	private static final String ATTRIBUT_EQUIPES_NUMBER = "equipesnumber";
	private static final String ATTRIBUT_VOYAGES_NUMBER = "voyagesnumber";
	private static final String ATTRIBUT_RESERVATION_EFFECTUE_NUMBER = "reservationsdonenumber";
	private static final String ATTRIBUT_RESERVATION_NON_EFFECTUE_NUMBER = "reservationsnotdonenumber";
	private static final String ATTRIBUT_EQUIPES = "equipes";
	private static final String ATTRIBUT_LOGIN = "isLogin";
	
	private static final String PATH_LOGIN = "client/loginclient";
	private static final String PATH_ADMIN_PAGE = "index-a";

	private static final String ATTRIBUT_ERROR = "error";
	private static final String REDIRECT_HOME_SPACE = "redirect:/";
	
	
	
	@GetMapping("/login")
	public ModelAndView getPageLoginAdmin(HttpServletRequest request) {
		ModelAndView model = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			model = new ModelAndView(REDIRECT_HOME_SPACE);
		} else {
			model = new ModelAndView(PATH_LOGIN);
			model.addObject(ATTRIBUT_LOGIN,true);
			String err = request.getParameter(ATTRIBUT_ERROR);
			if (err != null && err.equals("true")) {
				model.addObject(ATTRIBUT_ERROR, "Vos identifiants sont incorrects.");
			}
		}
		return model;
	}

	@GetMapping("/admin")
	public ModelAndView getIndexAdmin() {
		ModelAndView model = new ModelAndView(PATH_ADMIN_PAGE);
		List<Voyage> voyages = voyageRepository.findAll();
		List<Hotel> hotels = hotelRepository.findAll();
		List<Reservation> reservations = reservationRepository.findAll();
		List<Equipe> equipes = equipeRepository.findAll();
		model.addObject(ATTRIBUT_HOTELS_NUMBER, hotels.size());
		model.addObject(ATTRIBUT_RESERVATIONS_NUMBER, reservations.size());
		model.addObject(ATTRIBUT_EQUIPES_NUMBER, equipes.size());
		model.addObject(ATTRIBUT_VOYAGES_NUMBER, voyages.size());

		List<Reservation> reservationNotDone = reservations.stream().filter((r) -> !r.isConfirmed())
				.collect(Collectors.toList());
		model.addObject(ATTRIBUT_RESERVATION_NON_EFFECTUE_NUMBER, reservationNotDone.size());

		List<Reservation> reservationDone = reservations.stream().filter((r) -> r.isConfirmed())
				.collect(Collectors.toList());
		model.addObject(ATTRIBUT_RESERVATION_EFFECTUE_NUMBER, reservationDone.size());

		Collections.sort(equipes);
		if (equipes.size() <= 4) {
			model.addObject(ATTRIBUT_EQUIPES, equipes);
		} else {
			List<Equipe> newlist = new ArrayList<Equipe>();
			newlist.add(equipes.get(0));
			newlist.add(equipes.get(1));
			newlist.add(equipes.get(2));
			newlist.add(equipes.get(3));
			model.addObject(ATTRIBUT_EQUIPES, newlist);
		}

		return model;

	}

}
