package ma.wiebatouta.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ma.wiebatouta.exceptions.AddUnsatisfiedException;
import ma.wiebatouta.exceptions.DataEmptyException;
import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Hotel;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Reservation;
import ma.wiebatouta.models.Voyage;
import ma.wiebatouta.models.idcompose.KeyReservation;
import ma.wiebatouta.repositories.PersonneRepository;
import ma.wiebatouta.repositories.ReservationRepository;
import ma.wiebatouta.repositories.VoyageRepository;

@RestController
@RequestMapping(name="/api/reservation",value="/api/reservation")
@CrossOrigin(origins="*",allowedHeaders = "*")
public class ReservationRestController {

	@Autowired
	private ReservationRepository reservationRepository ;
	@Autowired
	private VoyageRepository voyageRepository ;
	@Autowired
	private PersonneRepository personRepository;
	
	@GetMapping
	@RolesAllowed("ADMIN")
	public ResponseEntity<?> getReservations(@RequestParam(name="id",required=false)Long id ) throws DataEmptyException, NotFoundException{
		List<Reservation> reservations = reservationRepository.findAll();
		if(reservations.size() == 0) {
			throw new DataEmptyException("La liste est vide ");
		}else {
			if(id!=null) {
				Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new NotFoundException("Id introuvable"));
				return ResponseEntity.ok(reservation);
			}else {
				return ResponseEntity.ok(reservations); 
			}
		}
	}
	
	@PostMapping
	public ResponseEntity<?> saveReservation(@RequestBody Reservation reservation) throws DataEmptyException, NotFoundException, AddUnsatisfiedException{
		HashMap<String, String> errors = new HashMap<String, String>();
		
		Voyage voyage = voyageRepository.findById(reservation.getIdVoyage()).orElseThrow(() -> new NotFoundException("Id not found"));
		Personne person = personRepository.findById(reservation.getIdPerson()).orElseThrow(() -> new NotFoundException("Id not found"));
		reservation.setVoyage(voyage);
		reservation.setPerson(person);
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Reservation>> violatons = validator.validate(reservation);
		for (ConstraintViolation<Reservation> constraintViolation : violatons) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}

		if (errors.size() != 0) {
			Gson gson = new Gson();
			String json = gson.toJson(errors);
			AddUnsatisfiedException exception = new AddUnsatisfiedException(json);
			throw exception;
		}
		
		return ResponseEntity.ok(reservation);
	}
		
}
