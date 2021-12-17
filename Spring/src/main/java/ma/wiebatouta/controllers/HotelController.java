package ma.wiebatouta.controllers;

import java.util.HashMap;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Hotel;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Picture;
import ma.wiebatouta.models.enums.TypePicture;
import ma.wiebatouta.repositories.HotelRepository;
import ma.wiebatouta.repositories.PictureRepository;
import ma.wiebatouta.services.interfaces.HotelServiceInterface;

@Controller
@RequestMapping("/admin/hotel")
public class HotelController {
	
	private final static String PATH_HOTEL = "hotel/index";
	private final static String ADD_PICTURE = "hotel/picture";
	
	private final static String ATTRIBUT_TYPES = "types";
	private final static String ATTRIBUT_ID_HOTEL = "idHotel";
	private final static String ATTRIBUT_PICTURES = "pictures";
	private final static String ATTRIBUT_ERRORS = "errors";
	private final static String REDIRECT_PICTURES_HOTEL = "redirect:/admin/hotel/picture?id=%d";
	
	
	@Autowired
	private HotelServiceInterface hotelMetier;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private PictureRepository pictureRepository;
	
	@GetMapping
	public ModelAndView getPageHotel() {
		ModelAndView model = new ModelAndView(PATH_HOTEL);
		model.addObject(DesignAttributes.ACTIVE_HOTEL,DesignAttributes.ACTIVE);
		hotelMetier.makeHotelModel(model);
		return model;
	}
	
	@GetMapping("/picture")
	public ModelAndView getPagePicture(@RequestParam("id")Long id) throws NotFoundException {
		ModelAndView model = new ModelAndView(ADD_PICTURE);
		Hotel hotel = hotelRepository.findById(id).orElseThrow(()->new NotFoundException("Id not found"));
		model.addObject(DesignAttributes.ACTIVE_HOTEL,DesignAttributes.ACTIVE);
		model.addObject(ATTRIBUT_TYPES,TypePicture.values());
		model.addObject(ATTRIBUT_ID_HOTEL,id);
		model.addObject(ATTRIBUT_PICTURES,hotel.getPictures());
		return model;
	}
	
	@PostMapping("/picture")
	public ModelAndView savePicture(@RequestParam("id")Long id,@RequestPayload Picture picture) throws NotFoundException {		
		HashMap<String,String> errors = new  HashMap<String,String>();
		ModelAndView model = new ModelAndView(ADD_PICTURE);
		Hotel hotel = hotelRepository.findById(id).orElseThrow(()->new NotFoundException("Id not found"));
		model.addObject(DesignAttributes.ACTIVE_HOTEL,DesignAttributes.ACTIVE);
		model.addObject(ATTRIBUT_TYPES,TypePicture.values());
		model.addObject(ATTRIBUT_ID_HOTEL,id);
		model.addObject(ATTRIBUT_PICTURES,hotel.getPictures());
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Picture>> violatons = validator.validate(picture);
		for (ConstraintViolation<Picture> constraintViolation : violatons) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}
		
		if(errors.size() == 0) {
			picture.setHotel(hotel);
			picture.setId(null);
			hotel.getPictures().add(picture);
			hotelRepository.save(hotel);
		}else {
			model.addObject(ATTRIBUT_ERRORS,errors);
		}
		
		return model;
	}
	
	@GetMapping("/picture/delete")
	public ModelAndView deletePicture(@RequestParam("id") Long id,@RequestParam("idPicture")Long idPicture) throws NotFoundException {
		pictureRepository.deleteById(idPicture);
		ModelAndView model = new ModelAndView(String.format(REDIRECT_PICTURES_HOTEL, id));
		return model;
	}
	
}
