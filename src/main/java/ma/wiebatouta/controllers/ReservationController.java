package ma.wiebatouta.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.interfaces.CountryMetier;
import ma.wiebatouta.interfaces.DesignAttributes;
import ma.wiebatouta.models.Country;

@Controller
@RequestMapping("/admin/reservation")
public class ReservationController {
	
	private final static String COUNTRY = "countries";
	private final static String PATH_RESERVATION ="admin/reservation/listeReservation";
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
