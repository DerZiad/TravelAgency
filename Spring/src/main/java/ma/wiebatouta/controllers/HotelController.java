package ma.wiebatouta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HotelController {
	
	private final static String PATH_HOTEL = "hotel/index";
	
	@GetMapping("/admin/hotel")
	public ModelAndView getPageHotel() {
		return new ModelAndView(PATH_HOTEL);
	}
}
