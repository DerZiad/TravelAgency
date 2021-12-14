package ma.wiebatouta.restcontroller;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.wiebatouta.exceptions.DataNotFoundException;
import ma.wiebatouta.models.Country;
import ma.wiebatouta.repositories.CountryRepository;

@RestController
@RequestMapping("/api/country")
public class CountryRestController {
	
	@Autowired
	private CountryRepository countryRepository;

	@GetMapping
	public HttpEntity<?> getCountries() throws DataNotFoundException{
		List<Country> countries = countryRepository.findAll();
		if(countries.size() == 0) 
			throw new DataNotFoundException();
		return ResponseEntity.ok(countries);
	}
}
