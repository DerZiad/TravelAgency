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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

class ReservationRequest {
	private Long idPerson;
	private Long idVoyage;

	public ReservationRequest(Long idPerson, Long idVoyage) {
		this.idPerson = idPerson;
		this.idVoyage = idVoyage;
	}

	public Long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	public Long getIdVoyage() {
		return idVoyage;
	}

	public void setIdVoyage(Long idVoyage) {
		this.idVoyage = idVoyage;
	}

}

@RestController
@RequestMapping(name = "/api/reservation", value = "/api/reservation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReservationRestController {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private VoyageRepository voyageRepository;
	@Autowired
	private PersonneRepository personRepository;

	@GetMapping
	@RolesAllowed("ADMIN")
	public ResponseEntity<?> getReservations(@RequestParam(name = "id", required = false) Long id)
			throws DataEmptyException, NotFoundException {
		List<Reservation> reservations = reservationRepository.findAll();
		if (reservations.size() == 0) {
			throw new DataEmptyException("La liste est vide ");
		} else {
			if (id != null) {
				Reservation reservation = reservationRepository.findById(id)
						.orElseThrow(() -> new NotFoundException("Id introuvable"));
				return ResponseEntity.ok(reservation);
			} else {
				return ResponseEntity.ok(reservations);
			}
		}
	}

	@PostMapping
	public ResponseEntity<?> saveReservation(@RequestBody ReservationRequest reservationRequest)
			throws DataEmptyException, NotFoundException, AddUnsatisfiedException {
		Reservation reservation = new Reservation();
		Voyage voyage = voyageRepository.findById(reservationRequest.getIdVoyage())
				.orElseThrow(() -> new NotFoundException("Id not found"));
		Personne person = personRepository.findById(reservationRequest.getIdPerson())
				.orElseThrow(() -> new NotFoundException("Id not found"));
		reservation.setVoyage(voyage);
		reservation.setPerson(person);

		reservationRepository.save(reservation);
		return ResponseEntity.ok(reservation);
	}

	@GetMapping("/username")
	@RolesAllowed("CLIENT")
	public ResponseEntity<?> getReservations(@RequestParam(name = "username", required = true) String username)
			throws DataEmptyException, NotFoundException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getName().equals(username)) {
			List<Reservation> reservations = reservationRepository.getReservationAvecUsername(username);
			return ResponseEntity.ok(reservations);
		}else {
			throw new DataEmptyException();
		}
	}

}
