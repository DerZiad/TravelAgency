package ma.wiebatouta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ma.wiebatouta.controllers.DesignAttributes;

@Controller
public class HotelController {
	
	private final static String PATH_HOTEL = "hotel/index";
	
	@GetMapping("/admin/hotel")
	public ModelAndView getPageHotel() {
		ModelAndView model = new ModelAndView(PATH_HOTEL);
		model.addObject(DesignAttributes.ACTIVE_HOTEL,DesignAttributes.ACTIVE);
		return model;
	}
}