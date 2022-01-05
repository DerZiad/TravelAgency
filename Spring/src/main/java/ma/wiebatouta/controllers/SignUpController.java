package ma.wiebatouta.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.mail.MessagingException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.metier.SignUpMetier;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.repositories.CountryRepository;
import ma.wiebatouta.repositories.PersonneRepository;

@Controller
@RequestMapping("/signup")

public class SignUpController {
	private final static String PATH_SIGNUP = "client/signup";
	private final static String ATTRIBUT_COUNTRIES = "countries";
	private final static String PAGE_SUCCES = "client/succes";
	private final static String ATTRIBUT_MESSAGE = "message";
	private final static String ATTRIBUT_ERRORS = "errors";

	@Autowired
	private PersonneRepository personneRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private SignUpMetier signUpMetier;

	@GetMapping
	public ModelAndView getPageSignUp() {
		ModelAndView model = new ModelAndView(PATH_SIGNUP);
		model.addObject(ATTRIBUT_COUNTRIES, countryRepository.findAll());
		return model;
	}

	@PostMapping()
	public ModelAndView signUp(/*
								 * @RequestParam("NomFr") String nom, @RequestParam("PrenomFr") String prenom,
								 * 
								 * @RequestParam("dateN") String dateN, @RequestParam("sexe") String sexe,
								 * 
								 * @RequestParam("lieuN_fr") String lieuNaissance,
								 * 
								 * @RequestParam(name = "marie", required = false) String
								 * marie, @RequestParam("nbenf") int nbenf,
								 * 
								 * @RequestParam("tel") String tel, @RequestParam("cin") String
								 * cin, @RequestParam("email") String email,
								 * 
								 * @RequestParam("codep") Long codep, @RequestParam("GroupSocio") String
								 * grpSocio,
								 * 
								 * @RequestParam("photo") MultipartFile photo
								 */@RequestPayload Personne personne) throws IOException, MessagingException {
		ModelAndView model = null;
		HashMap<String, String> errors = new HashMap<String, String>();
		/*
		 * boolean b = false; if (!marie.isEmpty()) { if (marie.equals("oui")) { b =
		 * true; } else { b = false; } }
		 * 
		 * Personne personne = new Personne(); dateN = dateN.replace("-", "/"); Date
		 * dateNaissance = new Date(dateN); personne.setCne(cin);
		 * personne.setCodePostal(codep); System.out.println(grpSocio);
		 * personne.setTravaille("medecin"); personne.setDateNaissance(dateNaissance);
		 * personne.setEmail(email); personne.setImagePart(photo); personne.setMarie(b);
		 * personne.setNationalite(lieuNaissance); Country country =
		 * cm.getCountryByKey(lieuNaissance);
		 * 
		 * personne.setNom(nom); personne.setPrenom(prenom);
		 * personne.setNombreEnfant(nbenf); if
		 * (Sexe.HOMME.name().equals(sexe.toUpperCase())) {
		 * personne.setSexe(Sexe.HOMME); } else { personne.setSexe(Sexe.FEMME); }
		 */
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Personne>> violatons = validator.validate(personne);
		for (ConstraintViolation<Personne> constraintViolation : violatons) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}
		/*
		 * ValidatorFactory factory1 = Validation.buildDefaultValidatorFactory();
		 * Validator validator1 = factory1.getValidator();
		 * 
		 * Set<ConstraintViolation<Country>> violatons1 = validator1.validate(country);
		 * for (ConstraintViolation<Country> constraintViolation : violatons1) {
		 * errors.put(constraintViolation.getPropertyPath().toString(),
		 * constraintViolation.getMessage()); }
		 */
		/*
		 * signUpMetier.createSignUp(nom, prenom, dateN, sexe, lieuNaissance, b, nbenf,
		 * tel, cin, email, codep, grpSocio, photo);
		 */
		if (errors.size() == 0) {
			model = new ModelAndView(PAGE_SUCCES);
			signUpMetier.createSignUp(personne);
			model.addObject(ATTRIBUT_MESSAGE, "Vous allez recevoir un email de confirmation de votre inscription");
		} else {
			model = new ModelAndView(PATH_SIGNUP);
			model.addObject(ATTRIBUT_ERRORS, errors);

		}
		return model;
	}

	@GetMapping("/confirmation/{codeVerif}/{idPersonne}")
	public ModelAndView confirmerEmail(@PathVariable("codeVerif") Long codeverif,
			@PathVariable("idPersonne") String idPersonne) throws NotFoundException {
		String code = String.valueOf(codeverif);
		Long id = Long.parseLong(idPersonne);
		Personne personne = personneRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Personne non trouvé"));
		signUpMetier.confirmerSignUP(code, id);
		ModelAndView model = new ModelAndView(PAGE_SUCCES);
		model.addObject(ATTRIBUT_MESSAGE, "Votre Inscription a ete confirme \n" + "Votre Username :" + personne.getNom()
				+ "\n" + "Votre PassWord  :" + personne.getPrenom());
		return model;
	}
}
