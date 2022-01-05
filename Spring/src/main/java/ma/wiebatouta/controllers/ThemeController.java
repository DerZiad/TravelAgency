package ma.wiebatouta.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.mail.MessagingException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.exceptions.DataNotFoundException;
import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.interfaces.DesignAttributes;
import ma.wiebatouta.interfaces.ThemeMetierInterface;
import ma.wiebatouta.models.Theme;

@Controller
@RequestMapping("/admin/theme")
public class ThemeController {
	private final static String PATH_THEME = "theme/addTheme";
	private final static String REDIRECT_LIST_THEMES = "redirect:/admin/theme";
	private final static String THEME = "themes";
	private final static String MODIFY = "modify";
	@Autowired
	private ThemeMetierInterface themeMetier;

	@GetMapping
	@RolesAllowed("ADMIN")
	public ModelAndView listeThemes() {
		ModelAndView model = new ModelAndView(PATH_THEME);
		List<Theme> themes = themeMetier.liseThemes();
		model.addObject(THEME, themes);
		model.addObject(DesignAttributes.ACTIVE_THEME_AJOUT, DesignAttributes.ACTIVE);
		return model;

	}

	@PostMapping
	@RolesAllowed("ADMIN")
	public ModelAndView createNewTheme(@RequestParam(name = "id", required = false) Long id,
			@RequestParam("name") String nom, @RequestParam("description") String description,
			@RequestParam(name = "logo",required=false) MultipartFile logo) throws IOException, MessagingException {
		ModelAndView model = new ModelAndView(PATH_THEME);
		ModelAndView model1 = new ModelAndView(REDIRECT_LIST_THEMES);
		Theme theme = null;
		if (id != null) {
			HashMap<String, String> errors = new HashMap<String, String>();
			try {
				
				theme = themeMetier.getThemeById(id);
				theme.setDescription(description);
				theme.setLabel(nom);
				theme.setPicture(theme.getPicture());
				ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
				Validator validator = factory.getValidator();
				Set<ConstraintViolation<Theme>> violations = validator.validate(theme);
				for (ConstraintViolation<Theme> constraintViolation : violations) {
					errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
				}
				boolean bool = false;
				if (errors.size() != 0) {
					model.addObject("theme", theme);
					model.addObject("errors", errors);
					bool = true;
					model.addObject("bool", bool);
					return model;
				} else {
					System.out.println();
					themeMetier.save(theme);
					return model1;
				}
			} catch (NotFoundException e) {
				errors.put("id", "Id not found");
			}

		} else {
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
	}

	@GetMapping("/{id}")
	@RolesAllowed("ADMIN")
	public ModelAndView modify(@PathVariable("id") String idTheme)
			throws EntityNotFoundException, DataNotFoundException, NotFoundException {
		ModelAndView model = new ModelAndView(PATH_THEME);
		Theme theme = themeMetier.getThemeById(idTheme);
		boolean modify = true;
		try {
			theme.encodeAll();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Theme> themes = themeMetier.liseThemes();
		model.addObject(THEME, themes);
		model.addObject("theme", theme);
		model.addObject(MODIFY, modify);
		return model;

	}
	
	@GetMapping("/deleteTheme/{id}")
	@RolesAllowed("ADMIN")
	public ModelAndView delete(@PathVariable("id")Long idTheme) {
		themeMetier.deleteTheme(idTheme);
		ModelAndView model = new ModelAndView(REDIRECT_LIST_THEMES);
		return model;
	}
}
