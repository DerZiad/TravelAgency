package ma.wiebatouta.restcontroller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.wiebatouta.exceptions.DataEmptyException;
import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Equipe;
import ma.wiebatouta.repositories.EquipeRepository;

@RestController
public class EquipeRestController {
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	@GetMapping("/api/equipes")
	@RolesAllowed("ADMIN")
	public ResponseEntity<?> findEquipes(@RequestParam(name = "id", required = false) Long id)
			throws DataEmptyException, NotFoundException {
		List<Equipe> equipes = equipeRepository.findAll();
		if (equipes.size() == 0) {
			throw new DataEmptyException("The list of catalogs is empty");
		} else {
			if (id != null) {
				Equipe equipe = equipeRepository.findById(id)
						.orElseThrow(() -> new NotFoundException("The id is not found"));
				return ResponseEntity.ok(equipe);
			} else {
				return ResponseEntity.ok(equipes);
			}
		}
		
	}
}
