package ma.wiebatouta.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/reservation")
public class ReservationController {

	private final static String PATH_RESERVATION ="reservation/listeReservation";
	
	
	@GetMapping
	@RolesAllowed("ADMIN")
	public ModelAndView listeReservation() {
		ModelAndView model = new ModelAndView(PATH_RESERVATION);
		model.addObject(DesignAttributes.ACTIVE_RESERVATION,DesignAttributes.ACTIVE);
		return model;
	}

}
