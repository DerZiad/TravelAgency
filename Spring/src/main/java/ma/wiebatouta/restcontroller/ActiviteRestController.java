package ma.wiebatouta.restcontroller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.dialect.RDMSOS2200Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ma.wiebatouta.exceptions.AddUnsatisfiedException;
import ma.wiebatouta.exceptions.DataEmptyException;
import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.metier.ActiviteMetierIMP;
import ma.wiebatouta.metier.ActivityMetier;
import ma.wiebatouta.models.Activite;
import ma.wiebatouta.models.Hotel;
import ma.wiebatouta.models.SousActivite;
import ma.wiebatouta.models.Voyage;
import ma.wiebatouta.repositories.ActiviteRepository;
import ma.wiebatouta.repositories.VoyageRepository;

@RestController
@RequestMapping(name = "/api/activite", value = "/api/activite")
public class ActiviteRestController {

	@Autowired
	private ActiviteRepository activiteRepository;
	@Autowired
	private VoyageRepository voyageRepository;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed("ADMIN")
	public HttpEntity<?> addActivite(@RequestBody Activite activite) throws NotFoundException, AddUnsatisfiedException {
		HashMap<String, String> errors = new HashMap<String, String>();
		System.out.println(activite);
		Long idVoyage = activite.getIdVoyage();
		Voyage voyage = voyageRepository.findById(idVoyage).orElseThrow(() -> new NotFoundException("Id introuvable"));
		activite.setVoyage(voyage);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Activite>> violatons = validator.validate(activite);
		for (ConstraintViolation<Activite> constraintViolation : violatons) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}
		if (errors.size() != 0) {
			Gson gson = new Gson();
			String json = gson.toJson(errors);
			AddUnsatisfiedException exception = new AddUnsatisfiedException(json);
			throw exception;
		}
		List<SousActivite> sousActivite = activite.getSousActivites();
		Validator validator1 = factory.getValidator();

		for (int i = 0; i < sousActivite.size(); i++) {
			Set<ConstraintViolation<SousActivite>> violatons1 = validator1.validate(sousActivite.get(i));
			for (ConstraintViolation<SousActivite> constraintViolation : violatons1) {
				if (constraintViolation.getPropertyPath().toString().equals("titre")) {
					errors.put("titre" + i, constraintViolation.getMessage());
				} else {
					errors.put("description" + i, constraintViolation.getMessage());

				}
			}
		}
		System.out.println("SA" + errors);
		
		if (errors.size() != 0) {
			Gson gson = new Gson();
			String json = gson.toJson(errors);
			AddUnsatisfiedException exception = new AddUnsatisfiedException(json);
			throw exception;
		}
		activiteRepository.save(activite);
		return ResponseEntity.ok(activite);

	}

	@PostMapping("/sousActivite")
	@RolesAllowed("ADMIN")
	public HttpEntity<?> addSousActivite(@RequestBody SousActivite sousActivite, @RequestParam Long idSousActivite)
			throws AddUnsatisfiedException {
		HashMap<String, String> errors = new HashMap<String, String>();
		Activite activite = activiteRepository.getById(idSousActivite);
		sousActivite.setActivite(activite);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<SousActivite>> violatons = validator.validate(sousActivite);
		for (ConstraintViolation<SousActivite> constraintViolation : violatons) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}
		if (errors.size() != 0) {
			Gson gson = new Gson();
			String json = gson.toJson(errors);
			AddUnsatisfiedException exception = new AddUnsatisfiedException(json);
			throw exception;
		}
		activite.getSousActivites().add(sousActivite);
		activiteRepository.save(activite);

		return ResponseEntity.ok(activite);
	}

	@GetMapping
	@RolesAllowed("ADMIN")
	public ResponseEntity<?> findActivite(@RequestParam(name = "id", required = false) Long id)
			throws NotFoundException, DataEmptyException {
		Voyage voyage = voyageRepository.getById(id);
		List<Activite> activites = voyage.getActivites();
		if (activites.size() == 0) {
			throw new DataEmptyException("The list of activity is Empty");
		} else {

			return ResponseEntity.ok(activites);
		}
	}

	@PutMapping
	@RolesAllowed("ADMIN")
	public HttpEntity<?> editActivite(@RequestBody Activite activite)
			throws NotFoundException, AddUnsatisfiedException {
		System.out.println("put");
		System.out.println(activite);
		HashMap<String, String> errors = new HashMap<String, String>();
		Long idVoyage = activite.getIdVoyage();
		Voyage voyage = voyageRepository.findById(idVoyage).orElseThrow(() -> new NotFoundException("Id introuvable"));
		activite.setVoyage(voyage);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Activite>> violatons = validator.validate(activite);
		for (ConstraintViolation<Activite> constraintViolation : violatons) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}
		if (errors.size() != 0) {
			Gson gson = new Gson();
			String json = gson.toJson(errors);
			AddUnsatisfiedException exception = new AddUnsatisfiedException(json);
			throw exception;
		}
		List<SousActivite> sousActivite = activite.getSousActivites();
		for (int i = 0; i < sousActivite.size(); i++) {
			sousActivite.get(i).setId(sousActivite.get(i).getId());
			sousActivite.get(i).setActivite(activite);
		}
		System.out.println("SA" + sousActivite);
		Validator validator1 = factory.getValidator();
		/*
		 * Set<ConstraintViolation<List<SousActivite>>> violatons11 =
		 * validator1.validate(sousActivite); for
		 * (ConstraintViolation<List<SousActivite>> constraintViolation : violatons11) {
		 * errors.put(constraintViolation.getPropertyPath().toString(),
		 * constraintViolation.getMessage()); }
		 */
		for (int i = 0; i < sousActivite.size(); i++) {
			Set<ConstraintViolation<SousActivite>> violatons1 = validator1.validate(sousActivite.get(i));
			for (ConstraintViolation<SousActivite> constraintViolation : violatons1) {
				if (constraintViolation.getPropertyPath().toString().equals("titre")) {
					errors.put("titre" + i, constraintViolation.getMessage());
				} else {
					errors.put("description" + i, constraintViolation.getMessage());

				}
			}
		}
		System.out.println(errors);

		if (errors.size() != 0) {
			Gson gson = new Gson();
			String json = gson.toJson(errors);
			AddUnsatisfiedException exception = new AddUnsatisfiedException(json);
			throw exception;
		}
		activite = activiteRepository.save(activite);
		return ResponseEntity.ok(activite);
	}
}
