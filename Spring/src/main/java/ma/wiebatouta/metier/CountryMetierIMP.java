package ma.wiebatouta.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Country;
import ma.wiebatouta.repositories.CountryRepository;

@Service
@Primary
public class CountryMetierIMP implements CountryMetier {
	
	@Autowired
	public CountryRepository cr ;
	
	@Override
	public List<Country> listeCountries() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Country getCountryByKey(String key) {
		// TODO Auto-generated method stub
		Country c = null;
		try {
			c = cr.findById(key).orElseThrow(() -> new NotFoundException());
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c ;
	}
	
	

}
