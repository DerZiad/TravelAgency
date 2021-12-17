package ma.wiebatouta.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import ma.wiebatouta.models.Hotel;
import ma.wiebatouta.models.Lieu;
import ma.wiebatouta.models.Voyage;
import ma.wiebatouta.repositories.HotelRepository;
import ma.wiebatouta.repositories.LieuRepository;
import ma.wiebatouta.repositories.VoyageRepository;
/*
@RestController
@RequestMapping(name = "/api/hotel", produces = MediaType.APPLICATION_JSON_VALUE, value = "/api/hotel")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VoyageRestController {
	
	@Autowired
	private VoyageRepository voyageRepository;

	@Autowired
	private LieuRepository lieuRepository;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@RolesAllowed("ADMIN")
	public HttpEntity<?> addHotel(@RequestBody Voyage voyage) throws AddUnsatisfiedException {
		HashMap<String, String> errors = new HashMap<String, String>();
	
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Voyage>> violatons = validator.validate(voyage);
		for (ConstraintViolation<Voyage> constraintViolation : violatons) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}

		if (errors.size() != 0) {
			Gson gson = new Gson();
			String json = gson.toJson(errors);
			AddUnsatisfiedException exception = new AddUnsatisfiedException(json);
			throw exception;
		}
		voyage.setId(null);
		voyageRepository.save(voyage);
		return ResponseEntity.ok(voyage);
	}

	@PutMapping
	@RolesAllowed("ADMIN")
	public HttpEntity<?> editHotel(@RequestBody Hotel hotel) throws AddUnsatisfiedException {
		HashMap<String, String> errors = new HashMap<String, String>();
		if (hotel.getIdLieu() != null) {
			try {
				hotel.setVille(lieuRepository.findById(hotel.getIdLieu())
						.orElseThrow(() -> new NotFoundException("L'id lieu n'est pas trouvé")));
			} catch (NotFoundException e) {
				hotel.setVille(null);
			}
		}

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Hotel>> violatons = validator.validate(hotel);
		for (ConstraintViolation<Hotel> constraintViolation : violatons) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}
		if (errors.size() != 0) {
			Gson gson = new Gson();
			String json = gson.toJson(errors);
			AddUnsatisfiedException exception = new AddUnsatisfiedException(json);
			throw exception;
		}
		hotel = voyageRepository.save(hotel);
		return ResponseEntity.ok(hotel);
	}
	
	@DeleteMapping
	@RolesAllowed("ADMIN")
	public ResponseEntity<?> deleteCatalog(@RequestParam("id") Long id) throws NotFoundException {
		Hotel hotel = voyageRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not found"));
		voyageRepository.delete(hotel);
		return ResponseEntity.accepted().build();
	}

	@GetMapping
	@RolesAllowed("ADMIN")
	public ResponseEntity<?> findCatalogs(@RequestParam(name = "id", required = false) Long id)
			throws DataEmptyException, NotFoundException {
		List<Hotel> hotels = voyageRepository.findAll();
		if (hotels.size() == 0) {
			throw new DataEmptyException("The list of catalogs is empty");
		} else {
			if (id != null) {
				Hotel hotel = voyageRepository.findById(id)
						.orElseThrow(() -> new NotFoundException("The id is not found"));
				return ResponseEntity.ok(hotel);
			} else {
				return ResponseEntity.ok(hotels);
			}
		}

	}

	@PostMapping("/setlieu")
	@RolesAllowed("ADMIN")
	public HttpEntity<?> addLieu(@RequestParam("LieuId") Long idLieu, @RequestParam("HotelId") Long idHotel)
			throws NotFoundException {
		Lieu lieu = lieuRepository.findById(idLieu)
				.orElseThrow(() -> new NotFoundException("L'id lieu n'est pas trouvé"));
		Hotel hotel = voyageRepository.findById(idHotel)
				.orElseThrow(() -> new NotFoundException("L'id hotel n'est pas trouvé"));
		hotel.setVille(lieu);
		voyageRepository.save(hotel);
		return ResponseEntity.accepted().build();
	}

	@GetMapping("/pictures")
	public HttpEntity<?> getPictures(@RequestParam("id") Long id) throws NotFoundException, DataEmptyException {
		Hotel hotel = voyageRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
		if (hotel.getPictures().size() == 0) {
			throw new DataEmptyException("The list of catalogs is empty");
		} else {
			return ResponseEntity.ok(hotel.getPictures());

		}
	}
}*/
