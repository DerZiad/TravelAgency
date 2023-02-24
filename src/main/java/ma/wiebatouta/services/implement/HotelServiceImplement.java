package ma.wiebatouta.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.interfaces.HotelServiceInterface;
import ma.wiebatouta.repositories.CountryRepository;

@Service
@Primary
public class HotelServiceImplement implements HotelServiceInterface{

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public void makeHotelModel(ModelAndView model) {
		model.addObject(ATTRIBUT_COUNTRIES,countryRepository.findAll());
		
	}

}
