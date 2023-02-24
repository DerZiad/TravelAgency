package ma.wiebatouta.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import ma.wiebatouta.models.idcompose.KeyLike;
import ma.wiebatouta.repositories.JadoreRepository;
import ma.wiebatouta.repositories.PersonneRepository;
import ma.wiebatouta.repositories.VoyageRepository;
class JadoreRequest {
	private Long idPerson;
	private Long idVoyage;

	public JadoreRequest(Long idPerson, Long idVoyage) {
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
@RequestMapping(name = "/api/like", value = "/api/like")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JadoreRestController {
	@Autowired
	private VoyageRepository voyageRepository;
	
	@Autowired
	private PersonneRepository personRepository;
	
	@Autowired
	private JadoreRepository jadoreRepository;
	
	@GetMapping("/{idPerson}")
	public ResponseEntity<?> getLikes(@PathVariable("idPerson")Long idPerson)
			throws DataEmptyException, NotFoundException, AddUnsatisfiedException {
		Personne person = personRepository.findById(idPerson)
				.orElseThrow(() -> new NotFoundException("Id not found"));
		return ResponseEntity.ok(jadoreRepository.findByPerson(person));
	}
	
	@PostMapping
	public ResponseEntity<?> saveLike(@RequestBody JadoreRequest jadoreRequest)
			throws DataEmptyException, NotFoundException, AddUnsatisfiedException {
		Jadore jadore = new Jadore();
		Voyage voyage = voyageRepository.findById(jadoreRequest.getIdVoyage())
				.orElseThrow(() -> new NotFoundException("Id not found"));
		Personne person = personRepository.findById(jadoreRequest.getIdPerson())
				.orElseThrow(() -> new NotFoundException("Id not found"));
		voyage.setReview(voyage.getReview() + 1);
		voyageRepository.save(voyage);
		
		jadore.setVoyage(voyage);
		jadore.setPerson(person);
		jadoreRepository.save(jadore);
		return ResponseEntity.ok(jadore);
	}
	
	@PostMapping("/delete/{idPerson}/{idVoyage}")
	public ResponseEntity<?> deleteLike(@PathVariable("idPerson")Long idPerson,@PathVariable("idVoyage")Long idVoyage)
			throws DataEmptyException, NotFoundException, AddUnsatisfiedException {
		Voyage voyage = voyageRepository.findById(idVoyage)
				.orElseThrow(() -> new NotFoundException("Id not found"));
		personRepository.findById(idPerson)
				.orElseThrow(() -> new NotFoundException("Id not found"));
		voyage.setReview(voyage.getReview() - 1);
		voyageRepository.save(voyage);
		

		jadoreRepository.deleteById(new KeyLike(idVoyage, idPerson));
		return ResponseEntity.accepted().build();
	}
}
