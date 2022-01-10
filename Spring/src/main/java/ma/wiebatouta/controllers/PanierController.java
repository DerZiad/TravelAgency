package ma.wiebatouta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Reservation;
import ma.wiebatouta.models.idcompose.KeyReservation;
import ma.wiebatouta.repositories.PersonneRepository;
import ma.wiebatouta.repositories.ReservationRepository;

@Controller
public class PanierController {

	private static final String PATH_PANIER = "client/panier";

	private static final String ATTRIBUT_RESERVATIONS = "reservations";
	private static final String ATTRIBUT_PRIX_TOTAL = "total";

	private static final String REDIRECT_LOGIN = "redirect:/login";
	private static final String REDIRECT_PANIER = "redirect:/panier";
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private PersonneRepository personneRepository;

	@GetMapping("/panier")
	public ModelAndView getPanier() {
		ModelAndView model = null;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			model = new ModelAndView(REDIRECT_LOGIN);
		} else {
			String username = auth.getName();
			model = new ModelAndView(PATH_PANIER);
			List<Reservation> reservations = reservationRepository.findAll();
			reservations = reservations.stream()
					.filter(r -> !r.isConfirmed() && r.getPerson().getUser().getUsername().equals(username)).toList();
			double prix = 0;
			for (Reservation reservation : reservations) {
				prix = prix + reservation.getVoyage().getPrix();
			}
			model.addObject(ATTRIBUT_PRIX_TOTAL, prix);
			model.addObject(ATTRIBUT_RESERVATIONS, reservations);
		}
		return model;
	}

	@GetMapping("/panier/delete")
	public ModelAndView getPanier(@RequestParam("idVoyage") Long idVoyage) {
		ModelAndView model = null;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			model = new ModelAndView(REDIRECT_LOGIN);
		} else {
			String username = auth.getName();
			Personne personne = personneRepository.getPersonneFromUsername(username);
			reservationRepository.deleteById(new KeyReservation(idVoyage, personne.getId()));
			model = new ModelAndView(REDIRECT_PANIER);
		}
		return model;
	}

	@GetMapping("/panier/payer")
	public ModelAndView payerPanier() {
		ModelAndView model = null;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			model = new ModelAndView(REDIRECT_LOGIN);
		} else {
			String username = auth.getName();
			List<Reservation> reservations = reservationRepository.getReservationAvecUsername(username);
			reservations.forEach(r -> {
				r.setConfirmed(true);
				r.getVoyage().setNbrPersonnes(r.getVoyage().getNbrPersonnes() + 1);
			});
			reservationRepository.saveAll(reservations);
			model = new ModelAndView(REDIRECT_PANIER);
		}
		return model;
	}
}
