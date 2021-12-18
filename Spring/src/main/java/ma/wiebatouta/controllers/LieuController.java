package ma.wiebatouta.controllers;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ma.wiebatouta.controllers.DesignAttributes;
import ma.wiebatouta.exceptions.DataNotFoundException;
import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.metier.CountryMetier;
import ma.wiebatouta.metier.LieuxMetier;
import ma.wiebatouta.models.Country;
import ma.wiebatouta.models.Lieu;
import ma.wiebatouta.models.Theme;

@Controller
@RequestMapping("/admin/lieux")
public class LieuController {
	private final static String LIEUX = "lieux";
	private final static String COUNTRY = "country";
	private final static String PATH_LIEU = "lieu/addLieu";
	private final static String REDIRECT_LIST_LIEUX = "redirect:/admin/lieux";
	@Autowired
	private LieuxMetier lieuMetier;
	@Autowired
	private CountryMetier cm;

	@GetMapping
	@RolesAllowed("ADMIN")
	public ModelAndView listeLieux() {
		ModelAndView model = new ModelAndView(PATH_LIEU);
		List<Lieu> lieux = lieuMetier.listeLieux();
		model.addObject(LIEUX, lieux);
		List<Country> country = cm.listeCountries();
		model.addObject(DesignAttributes.ACTIVE_LIEUX_AJOUT, DesignAttributes.ACTIVE);
		model.addObject(COUNTRY, country);
		return model;

	}

	@PostMapping
	@RolesAllowed("ADMIN")
	public ModelAndView saveLieu(@RequestParam(name = "id", required = false) Long id,
			@RequestParam("name") String name, @RequestParam("keycountry") String keyCountry) {
		ModelAndView model = new ModelAndView(PATH_LIEU);
		Lieu lieu = null;
		if (id != null) {
			HashMap<String, String> errors = new HashMap<String, String>();
			try {
				lieu = lieuMetier.getLieuById(id);
				Country country = cm.getCountryByKey(keyCountry);
				lieu.setLabel(name);
				lieu.setCountry(country);
				ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
				Validator validator = factory.getValidator();
				Set<ConstraintViolation<Lieu>> violations = validator.validate(lieu);
				for (ConstraintViolation<Lieu> constraintViolation : violations) {
					errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
				}
				boolean bool = false;
				if (errors.size() != 0) {
					model.addObject("errors", errors);
					bool = true;
					model.addObject("bool", bool);
				} else {
					lieuMetier.save(lieu);
				}
			} catch (Exception e) {
				// TODO: handle exception
				errors.put("id", "Id not found");

			}
		} else {
			HashMap<String, String> errors = new HashMap<String, String>();
			lieu = new Lieu();
			Country country = cm.getCountryByKey(keyCountry);
			lieu.setLabel(name);
			lieu.setCountry(country);
			lieu.setId(id);
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<Lieu>> violations = validator.validate(lieu);
			for (ConstraintViolation<Lieu> constraintViolation : violations) {
				errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
			}
			Set<ConstraintViolation<Country>> violations1 = validator.validate(country);
			for (ConstraintViolation<Country> constraintViolation : violations1) {
				errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
			}
			boolean bool = false;
			if (errors.size() != 0) {
				model.addObject("errors", errors);
				
				bool = true;
				model.addObject("bool", bool);
			} else {
				lieuMetier.save(lieu);
			}
		
		List<Lieu> lieux = lieuMetier.listeLieux();
		model.addObject(LIEUX, lieux);
		model.addObject(DesignAttributes.ACTIVE_THEME_AJOUT, DesignAttributes.ACTIVE);}
		return model;
	}

	@GetMapping("/{id}")
	@RolesAllowed("ADMIN")
	public ModelAndView modify(@PathVariable("id") Long idLieu)
			throws EntityNotFoundException, DataNotFoundException, NotFoundException {
		ModelAndView model = new ModelAndView(PATH_LIEU);
		System.out.println("id");
		Lieu lieu = lieuMetier.getLieuById(idLieu);		
		List<Lieu> lieux = lieuMetier.listeLieux();
		model.addObject(LIEUX, lieux);
		model.addObject("lieu", lieu);
		List<Country> country = cm.listeCountries();
		model.addObject(COUNTRY, country);
		return model;

	}

	@GetMapping("/deleteLieu/{id}")
	@RolesAllowed("ADMIN")
	public ModelAndView delete(@PathVariable("id")Long idLieu) {
		lieuMetier.deleteLieu(idLieu);
		ModelAndView model = new ModelAndView(REDIRECT_LIST_LIEUX);
		return model;
	}
}
