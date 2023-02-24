package ma.wiebatouta.services.writers;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.wiebatouta.models.Reservation;
import ma.wiebatouta.repositories.ReservationRepository;

@Component
public class ReservationWriter implements ItemWriter<List<Reservation>> {
	
	@Autowired
	private ReservationRepository reservationRepository;
		
	@Override
	public void write(List<? extends List<Reservation>> items) throws Exception {
		for (List<Reservation> list : items) {
			list.forEach(m -> {
				if (m.isDead()) {
					reservationRepository.delete(m);
				}
			});
		}

	}

}
