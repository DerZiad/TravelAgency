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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Theme;

@Controller
@RequestMapping("/admin/ressources")
public class EquipeController {
	
	private final static String PAGE_AJOUT_EQUIPE="ressourcehumaines/ressourcehumaines";
	
	@GetMapping
	public ModelAndView getRessources() {
		ModelAndView model = new ModelAndView(PAGE_AJOUT_EQUIPE);
		System.out.println("Take");
		return model;
	}
	/*
	@PostMapping
	@RolesAllowed("ADMIN")
	public ModelAndView createNewTheme(@RequestParam(name = "id", required = false) Long id,
			@RequestParam("name") String nom, @RequestParam("description") String description,
			@RequestParam(name = "logo") MultipartFile logo) throws IOException, MessagingException {
		ModelAndView model = new ModelAndView(PATH_THEME);
		Theme theme = null;
		if (id != null) {
			HashMap<String, String> errors = new HashMap<String, String>();
			try {
				theme = themeMetier.getThemeById(id);
				theme.setDescription(description);
				theme.setLabel(nom);
				ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
				Validator validator = factory.getValidator();
				Set<ConstraintViolation<Theme>> violations = validator.validate(theme);
				for (ConstraintViolation<Theme> constraintViolation : violations) {
					errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
				}
				boolean bool = false;
				if (errors.size() != 0) {
					model.addObject("errors", errors);
					bool = true;
					model.addObject("bool", bool);
				} else {
					themeMetier.save(theme);
				}
			} catch (NotFoundException e) {
				errors.put("id", "Id not found");
			}

		} else {
			System.out.println('n');
			HashMap<String, String> errors = new HashMap<String, String>();
			byte[] image = null;
			if (logo.getBytes().length != 0) {
				image = logo.getBytes();
			}
			theme = new Theme(nom, description, image);
			theme.setId(null);
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<Theme>> violations = validator.validate(theme);
			for (ConstraintViolation<Theme> constraintViolation : violations) {
				errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
			}
			boolean bool = false;
			if (errors.size() != 0) {
				model.addObject("errors", errors);
				bool = true;
				model.addObject("bool", bool);
			} else {
				themeMetier.save(theme);
			}
		}
		List<Theme> themes = themeMetier.liseThemes();
		model.addObject(THEME, themes);
		model.addObject(DesignAttributes.ACTIVE_THEME_AJOUT, DesignAttributes.ACTIVE);
		return model;
	}*/
}
