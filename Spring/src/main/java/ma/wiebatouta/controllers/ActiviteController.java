package ma.wiebatouta.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.models.Activite;
import ma.wiebatouta.models.Lieu;
import ma.wiebatouta.models.SousActivite;
import ma.wiebatouta.repositories.ActiviteRepository;
import ma.wiebatouta.repositories.SousActiviteRepository;

@Controller
@RequestMapping("/admin/activite")
public class ActiviteController {
	private final static String PATH_ACTIVTE = "Activite/addActivite";
	private final static String REDIRECT_LIST_ACTIVITY = "redirect:/admin/activite";
	@Autowired
	private ActiviteRepository activiteRepository;
	@Autowired
	private SousActiviteRepository sousActiviteRepository;

	@GetMapping
	@RolesAllowed("ADMIN")
	public ModelAndView listeActivite() {
		ModelAndView model = new ModelAndView(PATH_ACTIVTE);
		List<Activite> activities = activiteRepository.findAll();
		int x = 0;
		int cmp = 0;
		for (Activite activite : activities) {
			List<SousActivite> sousActivities = sousActiviteRepository.getSousActiviteByActivite(activite);
			model.addObject("sousActivite" + x, sousActivities);
			x++;
		}
		model.addObject(DesignAttributes.ACTIVE_ACTIVITY_AJOUT, DesignAttributes.ACTIVE);
		model.addObject("activities", activities);
		model.addObject("cmp", cmp);
		
		return model;
	}

	@PostMapping
	@RolesAllowed("ADMIN")
	public ModelAndView createNewActivity(@RequestParam MultiValueMap<String, String> params) {
		List<String> id = params.get("id");
		ModelAndView model = new ModelAndView(REDIRECT_LIST_ACTIVITY);
		Activite activite = null;
		List<SousActivite> sousActivities = null;

		HashMap<String, String> errors = new HashMap<String, String>();
		HashMap<String, String> errors1 = new HashMap<String, String>();
		String labelActivite = params.get("name").get(0);
		String descriptionActivite = params.get("description").get(0);
		activite = new Activite();
		activite.setDescription(descriptionActivite);
		activite.setNomActivite(labelActivite);
		System.out.println(activite);
		int tailleSousActivite = params.get("myparams").size();
		System.out.println( params.get("myparams"));
		sousActivities = new ArrayList<>(tailleSousActivite);
		for (int i = 0; i < tailleSousActivite; i++) {
			SousActivite sousActivite = new SousActivite();
			sousActivite.setTitre(params.get("myparams").get(i));
			sousActivite.setDescription(params.get("SousActdescrip").get(i));
			sousActivite.setActivite(activite);
			sousActivities.add(sousActivite);
			
		}
		System.out.println(sousActivities);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Activite>> violations = validator.validate(activite);
		for (ConstraintViolation<Activite> constraintViolation : violations) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}

		Set<ConstraintViolation<List<SousActivite>>> violations1 = validator.validate(sousActivities);
		for (ConstraintViolation<List<SousActivite>> constraintViolation : violations1) {
			errors1.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}
		boolean bool = false;
		boolean bool1 = false;
		System.out.println("errors" + errors.size());
		System.out.println(errors.toString());
		System.out.println("errors2" + errors1.size());
		System.out.println(errors1.toString());
		if (errors.size() != 0) {
			model.addObject("errors", errors);
			bool = true;
			model.addObject("bool", bool);
		} else if (errors1.size() != 0) {
			model.addObject("errors1", errors1);
			bool1 = true;
			model.addObject("bool1", bool1);
		} else {
			activiteRepository.save(activite);
			for (int i = 0; i < tailleSousActivite; i++) {
				sousActiviteRepository.save(sousActivities.get(i));
			}

		
		}
		return model;
	}
}
