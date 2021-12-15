package ma.wiebatouta.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.mail.MessagingException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import io.swagger.models.Model;
import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Country;
import ma.wiebatouta.models.Equipe;
import ma.wiebatouta.models.Hotel;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Theme;
import ma.wiebatouta.repositories.CountryRepository;
import ma.wiebatouta.repositories.EquipeRepository;

@Controller
@RequestMapping("/admin/ressources")
public class EquipeController {

	private final static String PAGE_AJOUT_EQUIPE = "ressourcehumaines/ressourcehumaines";
	private final static String PAGE_LIST_EQUIPES = "ressourcehumaines/ressources";
	private final static String REDIRECT_LIST_EQUIPES = "redirect:/admin/ressources";

	private final static String ATTRIBUT_COUNTRIES = "countries";
	private final static String ATTRIBUT_EQUIPES = "equipes";
	private final static String ATTRIBUT_ERRORS = "errors";

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private EquipeRepository equipeController;

	@GetMapping
	public ModelAndView getRessources() {
		ModelAndView model = new ModelAndView(PAGE_LIST_EQUIPES);
		model.addObject(ATTRIBUT_EQUIPES, equipeController.findAll());
		return model;
	}

	@GetMapping("/add")
	public ModelAndView getRessource() {
		ModelAndView model = new ModelAndView(PAGE_AJOUT_EQUIPE);
		List<Country> countries = countryRepository.findAll();
		model.addObject(ATTRIBUT_COUNTRIES, countries);
		return model;
	}

	@PostMapping("/add")
	@RolesAllowed("ADMIN")
	public ModelAndView createNewTheme(@RequestPayload Equipe equipe, @RequestPayload Personne person)
			throws IOException, MessagingException {
		ModelAndView model = null;
		HashMap<String, String> errors = new HashMap<String, String>();
		
		System.out.println(equipe);
		System.out.println(person);
		
		/*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Personne>> violatons = validator.validate(person);
		for (ConstraintViolation<Personne> constraintViolation : violatons) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}

		Set<ConstraintViolation<Equipe>> violatons1 = validator.validate(equipe);
		for (ConstraintViolation<Equipe> constraintViolation : violatons1) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}*/

		if (errors.size() == 0) {
			equipe.setPersonne(person);
			equipeController.save(equipe);
			model = new ModelAndView(REDIRECT_LIST_EQUIPES);
		} else {
			model = new ModelAndView(PAGE_AJOUT_EQUIPE);
			List<Country> countries = countryRepository.findAll();
			model.addObject(ATTRIBUT_COUNTRIES, countries);
			model.addObject(ATTRIBUT_ERRORS, errors);
		}
		model.addObject(DesignAttributes.ACTIVE_THEME_AJOUT, DesignAttributes.ACTIVE);
		return model;
	}
}
