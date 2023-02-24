package ma.wiebatouta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Reservation;
import ma.wiebatouta.repositories.PersonneRepository;
import ma.wiebatouta.repositories.ReservationRepository;

@Controller
@RequestMapping("/mesreservations")
public class MyReservationController {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private PersonneRepository personneRepository;

	private final static String PAGE_MES_RESERVATIONS = "client/mesreservations";

	private final static String ATTRIBUT_MES_RESERVATIONS = "reservations";

	@GetMapping
	private ModelAndView getReservations(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return new ModelAndView("redirect:/login");
		} else {
			ModelAndView model = new ModelAndView(PAGE_MES_RESERVATIONS);
			Personne personne = personneRepository.getPersonneFromUsername(auth.getName());
			System.out.println(personne.getNationalite());
			Pageable pageInc = PageRequest.of(page, size);
			Page<Reservation> pages = reservationRepository.findAllByPerson(personne, pageInc);
			// List<Reservation> reservations =
			// reservationRepository.getReservationAvecUsername(auth.getName());
			List<Reservation> reservations = pages.getContent();
			reservations = reservations.stream().filter((r) -> r.isConfirmed()).toList();
			model.addObject("data", pages.getContent());
			model.addObject("number", pages.getNumber());
			model.addObject("totalPages", pages.getTotalPages());
			model.addObject("totalElements", pages.getTotalElements());
			model.addObject("size", pages.getSize());
			model.addObject(ATTRIBUT_MES_RESERVATIONS, reservations);
			model.addObject("personne", auth.getName());
			return model;
		}

	}
}
