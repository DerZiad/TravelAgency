package ma.wiebatouta.controllers;

import java.util.List;

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

	@Autowired private VoyageRepository voyageRepository;
	@Autowired private HotelRepository hotelRepository;
	@Autowired private ReservationRepository reservationRepository;
	@Autowired private EquipeRepository equipeRepository;
	
	
	
	private static final String PATH_ADMIN_LOGIN = "login";
	private static final String PATH_ADMIN_PAGE = "index-a";
	
	private static final String ATTRIBUT_ERROR = "error";
	private static final String REDIRECT_ADMIN_SPACE = "redirect:/admin/";

	@GetMapping("/admin/login")
	public ModelAndView getPageLoginAdmin(HttpServletRequest request) {
		ModelAndView model = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			model = new ModelAndView(REDIRECT_ADMIN_SPACE);
		} else {
			model = new ModelAndView(PATH_ADMIN_LOGIN);
			String err = request.getParameter(ATTRIBUT_ERROR);
			if (err != null && err.equals("true")) {
				model.addObject(ATTRIBUT_ERROR, "Vos identifiants sont incorrects.");
			}
		}
		return model;
	}
	
	@GetMapping("/admin/")
	public ModelAndView getIndexAdmin() {
		List<Voyage> voyages = voyageRepository.findAll();
		List<Hotel> hotels = hotelRepository.findAll();
		List<Reservation> reservations = reservationRepository.findAll();
		List<Equipe> equipes = equipeRepository.findAll();
		return new ModelAndView(PATH_ADMIN_PAGE);
	}
}
