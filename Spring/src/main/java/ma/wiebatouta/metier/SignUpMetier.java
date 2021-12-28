package ma.wiebatouta.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.wiebatouta.repositories.PersonneRepository;

@Service
public class SignUpMetier {

	@Autowired
	private PersonneRepository personneRepository;
	
	public void createSignUp(String nom,String prenom,Date date,String sexe ) {
		
	}
}
