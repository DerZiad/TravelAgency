package ma.wiebatouta.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.metier.SignUpMetier;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Sexe;
import ma.wiebatouta.repositories.CountryRepository;

import java.io.IOException;
import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/signup")

public class SignUpController {
	private final static String PATH_SIGNUP = "client/signup";
	private final static String ATTRIBUT_COUNTRIES = "countries";
	private final static String PAGE_SUCCES = "client/succes";
	private final static String ATTRIBUT_MESSAGE = "message";

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
	public ModelAndView signUp(@RequestParam("NomFr") String nom, @RequestParam("PrenomFr") String prenom,
			@RequestParam("dateN") String dateN, @RequestParam("sexe") String sexe,
			@RequestParam("lieuN_fr") String lieuNaissance, @RequestParam("marie") String marie,
			@RequestParam("nbenf") int nbenf, @RequestParam("tel") String tel, @RequestParam("cin") String cin,
			@RequestParam("email") String email, @RequestParam("codep") Long codep,
			@RequestParam("GroupSocio") String grpSocio, @RequestParam("photo") MultipartFile photo)
			throws IOException, MessagingException {
		ModelAndView model = new ModelAndView(PAGE_SUCCES);
		boolean b = false;
		if (marie.equals("oui")) {
			b = true;
		} else {
			b = false;
		}
		model.addObject(ATTRIBUT_MESSAGE, "Vous allez recevoir un email de confirmation de votre inscription");
		signUpMetier.createSignUp(nom, prenom, dateN, sexe, lieuNaissance, b, nbenf, tel, cin, email, codep, grpSocio,
				photo);

		return model;
	}

	@GetMapping("/confirmation/{codeVerif}/{idPersone}")
	public ModelAndView confirmerEmail(@PathVariable("codeVerif") Long codeverif,
			@PathVariable("idPersonne") Long idPersonne) {
		String code = String.valueOf(codeverif);
		signUpMetier.confirmerSignUP(code, idPersonne);
		ModelAndView model = new ModelAndView(PAGE_SUCCES);
		model.addObject(ATTRIBUT_MESSAGE, "Votre Inscription a ete confirme");
		return model;
	}
}
