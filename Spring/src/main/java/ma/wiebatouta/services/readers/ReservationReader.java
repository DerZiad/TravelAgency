package ma.wiebatouta.services.readers;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.wiebatouta.models.Reservation;
import ma.wiebatouta.repositories.ReservationRepository;
@Component
public class ReservationReader implements ItemReader<List<Reservation>>{
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public List<Reservation> read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		return reservationRepository.findAll();
	}

}
