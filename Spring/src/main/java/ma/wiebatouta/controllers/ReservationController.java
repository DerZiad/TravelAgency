package ma.wiebatouta.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.metier.CountryMetier;
import ma.wiebatouta.models.Country;
import ma.wiebatouta.models.Reservation;

@Controller
@RequestMapping("/admin/reservation")
public class ReservationController {
	
	private final static String COUNTRY = "countries";
	private final static String PATH_RESERVATION ="reservation/listeReservation";
	@Autowired
	private CountryMetier countryMetier;
	
	@GetMapping
	@RolesAllowed("ADMIN")
	public ModelAndView listeReservation() {
		ModelAndView model = new ModelAndView(PATH_RESERVATION);
		model.addObject(DesignAttributes.ACTIVE_RESERVATION,DesignAttributes.ACTIVE);
		List<Country> countries = countryMetier.listeCountries();
		model.addObject(COUNTRY, countries);
		return model;
	}
}
