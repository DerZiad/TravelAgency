package ma.wiebatouta.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.wiebatouta.exceptions.AddUnsatisfiedException;
import ma.wiebatouta.exceptions.DataEmptyException;
import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Jadore;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Voyage;
import ma.wiebatouta.repositories.JadoreRepository;
import ma.wiebatouta.repositories.PersonneRepository;
import ma.wiebatouta.repositories.VoyageRepository;

@RestController
@RequestMapping(name = "/api/like", value = "/api/like")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JadoreRestController {
	@Autowired
	private VoyageRepository voyageRepository;
	
	@Autowired
	private PersonneRepository personRepository;
	
	@Autowired
	private JadoreRepository jadoreRepository;
	
	@PostMapping
	public ResponseEntity<?> saveLike(@RequestBody ReservationRequest reservationRequest)
			throws DataEmptyException, NotFoundException, AddUnsatisfiedException {
		Jadore jadore = new Jadore();
		Voyage voyage = voyageRepository.findById(reservationRequest.getIdVoyage())
				.orElseThrow(() -> new NotFoundException("Id not found"));
		Personne person = personRepository.findById(reservationRequest.getIdPerson())
				.orElseThrow(() -> new NotFoundException("Id not found"));
		voyage.setReview(voyage.getReview() + 1);
		voyageRepository.save(voyage);
		
		jadore.setVoyage(voyage);
		jadore.setPerson(person);

		jadoreRepository.save(jadore);
		return ResponseEntity.ok(jadore);
	}
}
