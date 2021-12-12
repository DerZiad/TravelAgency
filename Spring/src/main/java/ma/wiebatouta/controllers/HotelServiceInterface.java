package ma.wiebatouta.controllers;

import org.springframework.web.servlet.ModelAndView;

public interface HotelServiceInterface {
	public final static String ATTRIBUT_COUNTRIES = "countries";

	public void makeHotelModel(ModelAndView model);
}
