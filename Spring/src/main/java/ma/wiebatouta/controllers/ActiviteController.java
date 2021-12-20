package ma.wiebatouta.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.mail.MessagingException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.metier.ActiviteMetierIMP;
import ma.wiebatouta.metier.ActivityMetier;
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

	@Autowired
	public ActivityMetier activityMetier;

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
	public ModelAndView createNewActivity(@RequestParam(required = false) MultiValueMap<String, String> params)
			throws MessagingException {
		String id = params.get("id").get(0);
		ModelAndView model = new ModelAndView(PATH_ACTIVTE);
		Activite activite = null;
		List<SousActivite> sousActivities = new ArrayList<SousActivite>();
		if (id.equals("")) {
			HashMap<String, String> errors = new HashMap<String, String>();
			HashMap<String, String> errors1 = new HashMap<String, String>();
			String labelActivite = params.get("name").get(0);
			String descriptionActivite = params.get("description").get(0);
			activite = new Activite();
			activite.setDescription(descriptionActivite);
			activite.setNomActivite(labelActivite);
			System.out.println(activite);
			int tailleSousActivite = params.get("myparams").size();
			System.out.println(tailleSousActivite);

			for (int i = 0; i < tailleSousActivite; i++) {
				SousActivite sousActivite = new SousActivite();
				sousActivite.setTitre(params.get("myparams").get(i));
				sousActivite.setDescription(params.get("SousActdescrip").get(i));
				sousActivite.setActivite(activite);
				sousActivities.add(sousActivite);

			}
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
			System.out.println("errors " + errors.size());
			System.out.println(errors.get("nomActivite"));
			System.out.println("errors2 " + errors1.size());
			System.out.println(errors1.toString());
			if (errors.size() != 0) {
				model.addObject("errors", errors);
				bool = true;
				System.out.println("TRUE");
				model.addObject("err", bool);
			} else if (errors1.size() != 0) {
				model.addObject("errors1", errors1);
				bool1 = true;
				model.addObject("bool1", bool1);
			} else {
				activiteRepository.save(activite);
				for (int i = 0; i < tailleSousActivite; i++) {
					sousActiviteRepository.save(sousActivities.get(i));
				}
				List<Activite> activities = activiteRepository.findAll();
				for (Activite ac : activities) {
					List<SousActivite> act = sousActiviteRepository.getSousActiviteByActivite(activite);
					model.addObject("sousActivite", act);

				}
				return new ModelAndView(REDIRECT_LIST_ACTIVITY);
			}
		} else {
			Long idActivite = Long.parseLong(id);
			System.out.println("idAct " + idActivite);
			HashMap<String, String> errors = new HashMap<String, String>();
			HashMap<String, String> errors1 = new HashMap<String, String>();

			activite = activityMetier.getActivteById(idActivite);
			String labelActivite = params.get("name").get(0);
			String descriptionActivite = params.get("description").get(0);
			activite.setDescription(descriptionActivite);
			activite.setNomActivite(labelActivite);
			List<SousActivite> tbdd = /*sousActiviteRepository.getSousActiviteByActivite(activite);*/activite.getSousActivites();
			System.out.println(tbdd);
			/* int tailleSousActivite = tbdd.size(); */
			int tailleparams = params.get("myparams").size();
			System.out.println(tailleparams);
			sousActivities = new ArrayList<>(tailleparams);
			for (int i = 0; i < tailleparams; i++) {
				if (i < tbdd.size()) {
					tbdd.get(i).setId(tbdd.get(i).getId());
					tbdd.get(i).setTitre(params.get("myparams").get(i));
					tbdd.get(i).setDescription(params.get("SousActdescrip").get(i));
					tbdd.get(i).setActivite(activite);
				} else {
					SousActivite ss = new SousActivite();
					ss.setTitre(params.get("myparams").get(i));
					ss.setDescription(params.get("SousActdescrip").get(i));
					ss.setActivite(activite);
					sousActivities.add(ss);
					System.out.println(ss);
				}
				sousActivities.addAll(tbdd);
			}
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
			boolean boolg = false;
			boolean bool1 = false;
			boolean bool2=false;
			if (errors.size() != 0 && errors1.size() != 0) {
				model.addObject("errors", errors);
				boolg = true;
				model.addObject("err", boolg);
				/*******/
				model.addObject("errors1", errors1);
				bool1 = true;
				model.addObject("err1", bool1);
			} else if (errors.size() != 0) {

				model.addObject("errors", errors);
				bool1 = true;
				model.addObject("err", bool1);
			} else if (errors1.size() != 0) {
				model.addObject("errors1", errors1);
				bool2 = true;
				model.addObject("bool", bool2);
			} else {
				activiteRepository.save(activite);
				for (int i = 0; i < tailleparams; i++) {
					sousActiviteRepository.save(sousActivities.get(i));
				}

			}
		}
		List<Activite> activities = activiteRepository.findAll();
		model.addObject(DesignAttributes.ACTIVE_ACTIVITY_AJOUT, DesignAttributes.ACTIVE);
		model.addObject("activities", activities);
		return model;
	}

	@GetMapping("/{id}")
	@RolesAllowed("ADMIN")
	public ModelAndView modify(@PathVariable("id") Long idActivite) throws NotFoundException {
		ModelAndView model = new ModelAndView(PATH_ACTIVTE);
		boolean bool = true;
		List<Activite> activites = activiteRepository.findAll();
		Activite activite = activiteRepository.findById(idActivite).orElseThrow(() -> new NotFoundException());
		model.addObject("activities", activites);
		model.addObject("activite", activite);
		model.addObject("etat", activite);
		model.addObject("modify", bool);
		return model;
	}

	@GetMapping("/deleteActivite/{id}")
	@RolesAllowed("ADMIN")
	public ModelAndView delete(@PathVariable("id") Long idActivite) {
		activiteRepository.deleteById(idActivite);
		ModelAndView model = new ModelAndView(REDIRECT_LIST_ACTIVITY);
		return model;
	}
}
