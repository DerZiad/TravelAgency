package ma.wiebatouta.restcontroller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.wiebatouta.exceptions.DataEmptyException;
import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.interfaces.LieuxMetier;
import ma.wiebatouta.models.Country;
import ma.wiebatouta.models.Lieu;
import ma.wiebatouta.repositories.CountryRepository;
import ma.wiebatouta.repositories.LieuRepository;

@RestController
@RequestMapping("/api/lieux")
public class LieuxRestController {
	@Autowired
	private LieuxMetier lieuxmetier ;
	
	@Autowired
	private LieuRepository lieuRepository;
	@Autowired 
	private CountryRepository countryRepository;
	
	@GetMapping
	@RolesAllowed("ADMIN")
	public ResponseEntity<?> getLieux(@RequestParam(name = "id", required = false) Long id) throws DataEmptyException, NotFoundException{
		List<Lieu> lieux = lieuxmetier.listeLieux();
		if (lieux.size() == 0) {
			throw new DataEmptyException("The list of lieux is empty");
		} else {
			if (id != null) {
				Lieu lieu = lieuRepository.findById(id)
						.orElseThrow(() -> new NotFoundException("The id is not found"));
				return ResponseEntity.ok(lieu);
			} else {
				return ResponseEntity.ok(lieux);
			
		}
		}}
	
	@PostMapping
	@RolesAllowed("ADMIN")
	public ResponseEntity<?> getLieu(@RequestParam(name="keyCountry")String keyCountry) throws NotFoundException {
		Country country = countryRepository.findById(keyCountry).orElseThrow(() -> new NotFoundException("The id is not found"));
		return ResponseEntity.ok(country);

	}
	
	
}
