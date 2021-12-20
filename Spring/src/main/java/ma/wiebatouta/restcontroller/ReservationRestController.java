package ma.wiebatouta.restcontroller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.wiebatouta.exceptions.DataEmptyException;
import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Reservation;
import ma.wiebatouta.repositories.ReservationRepository;

@RestController
@RequestMapping(name="/api/reservation",value="/api/reservation")
@CrossOrigin(origins="*",allowedHeaders = "*")
public class ReservationRestController {

	@Autowired
	private ReservationRepository reservationRepository ;
	@Autowired
	private VoyageRestController voyageRepository ;
	
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
	
}
