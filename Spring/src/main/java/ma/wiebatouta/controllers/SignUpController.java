package ma.wiebatouta.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.repositories.CountryRepository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/signup")
public class SignUpController {
	private final static String PATH_SIGNUP="client/signup";
	private final static String ATTRIBUT_COUNTRIES = "countries";
	
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping
	public ModelAndView getPageSignUp() {
		ModelAndView model = new ModelAndView(PATH_SIGNUP);
		model.addObject(ATTRIBUT_COUNTRIES, countryRepository.findAll());
		return model;
	}
	
	@PostMapping()
	public ModelAndView signUp(@RequestParam("NomFr")String nom, 
			@RequestParam("PrenomFr")String prenom,@RequestParam("dateN")Date dateN ,@RequestParam("Sexe")String sexe,@RequestParam("lieuN_fr")String lieuNaissance,@RequestParam("marie")String marie,
			@RequestParam("nbenf")int nbenf,@RequestParam("tel")String tel,@RequestParam("cin")String cin,@RequestParam("email")String email,@RequestParam("codep")Long codep,@RequestParam("GroupSocio")String grpSocio,@RequestParam("photo")MultipartFile photo) {
		
		return null;
	}
}
