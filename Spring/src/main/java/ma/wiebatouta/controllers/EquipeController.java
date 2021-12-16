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

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Country;
import ma.wiebatouta.models.Equipe;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.repositories.CountryRepository;
import ma.wiebatouta.repositories.EquipeRepository;
import ma.wiebatouta.repositories.PersonneRepository;

@Controller
@RequestMapping("/admin/ressources")
public class EquipeController {

	private final static String PAGE_AJOUT_EQUIPE = "ressourcehumaines/ressourcehumaines";
	private final static String PAGE_LIST_EQUIPES = "ressourcehumaines/ressources";
	private final static String REDIRECT_LIST_EQUIPES = "redirect:/admin/ressources";

	private final static String ATTRIBUT_COUNTRIES = "countries";
	private final static String ATTRIBUT_EQUIPES = "equipes";
	private final static String ATTRIBUT_EQUIPE = "equipe";
	private final static String ATTRIBUT_PERSONNE = "personne";
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
	public ModelAndView getRessource(@RequestParam(name = "id", required = false) Long id) throws NotFoundException {
		ModelAndView model = new ModelAndView(PAGE_AJOUT_EQUIPE);
		List<Country> countries = countryRepository.findAll();
		model.addObject(ATTRIBUT_COUNTRIES, countries);

		if (id != null) {
			Equipe equipe = equipeController.findById(id).orElseThrow(() -> new NotFoundException("L'id est invalide"));
			model.addObject(ATTRIBUT_PERSONNE, equipe.getPersonne());
			model.addObject(ATTRIBUT_EQUIPE, equipe);
		}
		return model;
	}

	@PostMapping("/add")
	@RolesAllowed("ADMIN")
	public ModelAndView createNewRessource(@RequestParam(name = "id", required = false) Long id, @RequestPayload Equipe equipe, @RequestPayload Personne person)
			throws IOException, MessagingException, NotFoundException {
		ModelAndView model = null;
		HashMap<String, String> errors = new HashMap<String, String>();

		if (id != null) {
			Equipe equipeGrab = equipeController.findById(id)
					.orElseThrow(() -> new NotFoundException("L'id est invalide"));// Verifier si l'id existe
			equipe.setId(id);
			person.setId(equipeGrab.getPersonne().getId());

			if (person.getImage() == null || person.getImage().length == 0) {
				person.setImage(equipeGrab.getPersonne().getImage());
			}
		}

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Personne>> violatons = validator.validate(person);
		for (ConstraintViolation<Personne> constraintViolation : violatons) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}

		Set<ConstraintViolation<Equipe>> violatons1 = validator.validate(equipe);
		for (ConstraintViolation<Equipe> constraintViolation : violatons1) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}

		if (errors.size() == 0) {
			equipe.setPersonne(person);
			equipeController.save(equipe);
			model = new ModelAndView(REDIRECT_LIST_EQUIPES);
		} else {
			System.out.println(errors);
			model = new ModelAndView(PAGE_AJOUT_EQUIPE);
			List<Country> countries = countryRepository.findAll();
			model.addObject(ATTRIBUT_COUNTRIES, countries);
			model.addObject(ATTRIBUT_ERRORS, errors);
		}
		model.addObject(DesignAttributes.ACTIVE_THEME_AJOUT, DesignAttributes.ACTIVE);
		return model;
	}

	@GetMapping("/delete")
	public ModelAndView deleteRessource(@RequestParam(name = "id", required = true) Long id) throws NotFoundException {
		ModelAndView model = new ModelAndView(REDIRECT_LIST_EQUIPES);
		equipeController.deleteById(id);
		return model;
	}
}
