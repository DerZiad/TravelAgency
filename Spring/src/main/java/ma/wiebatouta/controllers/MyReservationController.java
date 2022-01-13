package ma.wiebatouta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.models.Reservation;
import ma.wiebatouta.repositories.ReservationRepository;

@Controller
@RequestMapping("/myreservations")
public class MyReservationController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	private final static String PAGE_MES_RESERVATIONS= "client/mesreservations";
	
	private final static String ATTRIBUT_MES_RESERVATIONS = "reservations";
	
	@GetMapping
	private ModelAndView getReservations() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth instanceof AnonymousAuthenticationToken) {
			return new ModelAndView("redirect:/login");
		}else {
			ModelAndView model = new ModelAndView(PAGE_MES_RESERVATIONS);
			List<Reservation> reservations = reservationRepository.getReservationAvecUsername(auth.getName());
			reservations = reservations.stream().filter((r)->r.isConfirmed()).toList();
			model.addObject(ATTRIBUT_MES_RESERVATIONS,reservations);
			return model;
		}
		
	}
}
