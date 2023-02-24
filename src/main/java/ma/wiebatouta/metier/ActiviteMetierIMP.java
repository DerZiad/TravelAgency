package ma.wiebatouta.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.interfaces.ActivityMetier;
import ma.wiebatouta.models.Activite;
import ma.wiebatouta.repositories.ActiviteRepository;


@Service
@Primary
public class ActiviteMetierIMP implements ActivityMetier {
	
	
	@Autowired
	public ActiviteRepository activiteRepository;
	
	@Override
	public Activite getActivteById(Long id) {
		Activite a = null;
		try {
			a = activiteRepository.findById(id).orElseThrow(() -> new NotFoundException());
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a;
	}

}
