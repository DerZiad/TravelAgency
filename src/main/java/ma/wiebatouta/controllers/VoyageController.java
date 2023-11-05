package ma.wiebatouta.controllers;

import java.util.HashMap;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.interfaces.DesignAttributes;
import ma.wiebatouta.models.Hotel;
import ma.wiebatouta.models.Lieu;
import ma.wiebatouta.models.Picture;
import ma.wiebatouta.models.Theme;
import ma.wiebatouta.models.Voyage;
import ma.wiebatouta.models.enums.TypePicture;
import ma.wiebatouta.models.enums.TypeVoyage;
import ma.wiebatouta.repositories.CountryRepository;
import ma.wiebatouta.repositories.HotelRepository;
import ma.wiebatouta.repositories.LieuRepository;
import ma.wiebatouta.repositories.PictureRepository;
import ma.wiebatouta.repositories.ThemeRepository;
import ma.wiebatouta.repositories.VoyageRepository;

@RestController
@RequestMapping("/admin/voyage")
public class VoyageController {

	private final static String PATH_INDEX_VOYAGE = "admin/voyage/index";
	private final static String ADD_PICTURE = "admin/voyage/picture";
	private final static String ADD_LIEUX = "admin/voyage/lieux";
	private final static String ADD_HOTELES = "admin/voyage/hoteles";
	private final static String ADD_THEMES = "admin/voyage/themes";
	private final static String ATTRIBUT_TYPES = "types";
	private final static String ATTRIBUT_ID_VOYAGE = "idVoyage";
	private final static String ATTRIBUT_PICTURES = "pictures";
	private final static String ATTRIBUT_COUNTRIES = "countries";
	private final static String ATTRIBUT_TYPES_VOYAGES = "typeVoyages";
	private final static String ATTRIBUT_LIEUX = "lieux";
	private final static String ATTRIBUT_HOTELES = "hoteles";
	private final static String ATTRIBUT_HOTELES_ALL = "hotelesAll";
	private final static String ATTRIBUT_THEMES = "themes";
	private final static String ATTRIBUT_THEMES_ALL = "themesAll";
	private final static String ATTRIBUT_ERRORS = "errors";
	private final static String REDIRECT_PICTURES_HOTEL = "redirect:/admin/voyage/picture?id=%d";
	private final static String REDIRECT_LIEUX_VOYAGE = "redirect:/admin/voyage/lieux?id=%d";
	private final static String REDIRECT_HOTELES_VOYAGE = "redirect:/admin/voyage/hoteles?id=%d";
	private final static String REDIRECT_THEMES_VOYAGE = "redirect:/admin/voyage/themes?id=%d";
	
	@Autowired
	private VoyageRepository voyageRepository;

	@Autowired
	private PictureRepository pictureRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private LieuRepository lieuRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private ThemeRepository themeRepository;
	
	@GetMapping
	public ModelAndView getPageIndexVoyage() {
		ModelAndView model = new ModelAndView(PATH_INDEX_VOYAGE);
		model.addObject(DesignAttributes.ACTIVE_VOYAGE, DesignAttributes.ACTIVE);
		model.addObject(ATTRIBUT_TYPES_VOYAGES,TypeVoyage.values());
		return model;
	}
	
	@GetMapping("/lieux")
	public ModelAndView getLieux(@RequestParam("id") Long id) throws NotFoundException {
		ModelAndView model = new ModelAndView(ADD_LIEUX);
		Voyage voyage = voyageRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
		model.addObject(DesignAttributes.ACTIVE_VOYAGE, DesignAttributes.ACTIVE);
		model.addObject(ATTRIBUT_COUNTRIES, countryRepository.findAll());
		model.addObject(ATTRIBUT_LIEUX,voyage.getLieux());
		model.addObject(ATTRIBUT_ID_VOYAGE, id);
		return model;
	}
	
	@PostMapping("/lieux")
	public ModelAndView saveLieu(@RequestParam("id") Long id, @RequestParam("lieu")Long idLieu)
			throws NotFoundException {
		Voyage voyage = voyageRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
		Lieu lieu = lieuRepository.findById(idLieu).orElseThrow(() -> new NotFoundException("Id not found"));
		voyage.addLieu(lieu);
		lieu.getVoyages().add(voyage);
		voyageRepository.save(voyage);
		ModelAndView model = new ModelAndView(String.format(REDIRECT_LIEUX_VOYAGE,id));
		return model;
	}
	
	@GetMapping("/lieux/delete")
	public ModelAndView deleteLieu(@RequestParam("id") Long id, @RequestParam("idLieu") Long idLieu)
			throws NotFoundException {
		Voyage voyage = voyageRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
		Lieu lieu = lieuRepository.findById(idLieu).orElseThrow(() -> new NotFoundException("Id not found"));
		voyage.getLieux().remove(lieu);
		lieu.getVoyages().remove(voyage);
		voyageRepository.save(voyage);
		ModelAndView model = new ModelAndView(String.format(REDIRECT_LIEUX_VOYAGE, id));
		return model;
	}
	
	@GetMapping("/hoteles")
	public ModelAndView getHoteles(@RequestParam("id") Long id) throws NotFoundException {
		ModelAndView model = new ModelAndView(ADD_HOTELES);
		Voyage voyage = voyageRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
		model.addObject(DesignAttributes.ACTIVE_VOYAGE, DesignAttributes.ACTIVE);
		model.addObject(ATTRIBUT_HOTELES_ALL,hotelRepository.findAll());
		model.addObject(ATTRIBUT_HOTELES,voyage.getHoteles());
		model.addObject(ATTRIBUT_ID_VOYAGE, id);
		return model;
	}
	
	@PostMapping("/hoteles")
	public ModelAndView saveHotele(@RequestParam("id") Long id, @RequestParam("hotele")Long idHotel)
			throws NotFoundException {
		Voyage voyage = voyageRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
		Hotel hotel = hotelRepository.findById(idHotel).orElseThrow(() -> new NotFoundException("Id not found"));
		voyage.getHoteles().add(hotel);
		hotel.getVoyages().add(voyage);
		voyageRepository.save(voyage);
		ModelAndView model = new ModelAndView(String.format(REDIRECT_HOTELES_VOYAGE,id));
		return model;
	}
	
	@GetMapping("/hoteles/delete")
	public ModelAndView deleteHotel(@RequestParam("id") Long id, @RequestParam("idHotel") Long idLieu)
			throws NotFoundException {
		Voyage voyage = voyageRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
		Hotel hotel = hotelRepository.findById(idLieu).orElseThrow(() -> new NotFoundException("Id not found"));
		voyage.getHoteles().remove(hotel);
		hotel.getVoyages().remove(voyage);
		voyageRepository.save(voyage);
		ModelAndView model = new ModelAndView(String.format(REDIRECT_HOTELES_VOYAGE, id));
		return model;
	}
	
	
	@GetMapping("/themes")
	public ModelAndView getThemes(@RequestParam("id") Long id) throws NotFoundException {
		ModelAndView model = new ModelAndView(ADD_THEMES);
		Voyage voyage = voyageRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
		model.addObject(DesignAttributes.ACTIVE_VOYAGE, DesignAttributes.ACTIVE);
		model.addObject(ATTRIBUT_THEMES_ALL,themeRepository.findAll());
		model.addObject(ATTRIBUT_THEMES,voyage.getThemes());
		model.addObject(ATTRIBUT_ID_VOYAGE, id);
		return model;
	}
	
	@PostMapping("/themes")
	public ModelAndView saveTheme(@RequestParam("id") Long id, @RequestParam("theme")Long idTheme)
			throws NotFoundException {
		Voyage voyage = voyageRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
		Theme theme = themeRepository.findById(idTheme).orElseThrow(() -> new NotFoundException("Id not found"));
		voyage.getThemes().add(theme);
		theme.getVoyages().add(voyage);
		voyageRepository.save(voyage);
		ModelAndView model = new ModelAndView(String.format(REDIRECT_THEMES_VOYAGE,id));
		return model;
	}
	
	@GetMapping("/themes/delete")
	public ModelAndView deleteTheme(@RequestParam("id") Long id, @RequestParam("idTheme") Long idLieu)
			throws NotFoundException {
		Voyage voyage = voyageRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
		Theme theme = themeRepository.findById(idLieu).orElseThrow(() -> new NotFoundException("Id not found"));
		voyage.getThemes().remove(theme);
		theme.getVoyages().remove(voyage);
		voyageRepository.save(voyage);
		ModelAndView model = new ModelAndView(String.format(REDIRECT_THEMES_VOYAGE, id));
		return model;
	}

	@GetMapping("/picture")
	public ModelAndView getPagePicture(@RequestParam("id") Long id) throws NotFoundException {
		ModelAndView model = new ModelAndView(ADD_PICTURE);
		Voyage hotel = voyageRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
		model.addObject(DesignAttributes.ACTIVE_VOYAGE, DesignAttributes.ACTIVE);
		model.addObject(ATTRIBUT_TYPES, TypePicture.values());
		model.addObject(ATTRIBUT_ID_VOYAGE, id);
		model.addObject(ATTRIBUT_PICTURES, hotel.getPictures());
		return model;
	}

	@PostMapping("/picture")
	public ModelAndView savePicture(@RequestParam("id") Long id, @RequestPayload Picture picture)
			throws NotFoundException {
		HashMap<String, String> errors = new HashMap<String, String>();
		ModelAndView model = new ModelAndView(ADD_PICTURE);
		Voyage voyage = voyageRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
		model.addObject(DesignAttributes.ACTIVE_HOTEL, DesignAttributes.ACTIVE);
		model.addObject(ATTRIBUT_TYPES, TypePicture.values());
		model.addObject(ATTRIBUT_ID_VOYAGE, id);
		model.addObject(ATTRIBUT_PICTURES, voyage.getPictures());

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Picture>> violatons = validator.validate(picture);
		for (ConstraintViolation<Picture> constraintViolation : violatons) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}

		if (errors.size() == 0) {
			picture.setVoyage(voyage);
			picture.setId(null);
			voyage.getPictures().add(picture);
			voyageRepository.save(voyage);
		} else {
			model.addObject(ATTRIBUT_ERRORS, errors);
		}

		return model;
	}

	@GetMapping("/picture/delete")
	public ModelAndView deletePicture(@RequestParam("id") Long id, @RequestParam("idPicture") Long idPicture)
			throws NotFoundException {
		pictureRepository.deleteById(idPicture);
		ModelAndView model = new ModelAndView(String.format(REDIRECT_PICTURES_HOTEL, id));
		return model;
	}

}
