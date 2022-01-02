package ma.wiebatouta.metier;

import java.io.IOException;
import java.sql.Date;

import javax.mail.MessagingException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Sexe;
import ma.wiebatouta.models.User;
import ma.wiebatouta.repositories.PersonneRepository;
import ma.wiebatouta.repositories.UserRepository;
import ma.wiebatouta.services.EmailService;

@Service
public class SignUpMetier {

	@Autowired
	private PersonneRepository personneRepository;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserRepository userRepository;

	public void createSignUp(String nom, String prenom, String date, String sexe, String lieuNaissance, boolean marie,
			int nbenf, String tel, String cin, String email, Long codep, String grpSocio, MultipartFile photo)
			throws IOException, MessagingException {
		Personne personne = new Personne();
		Date dn = Date.valueOf(date);
		personne.setCne(cin);
		personne.setCodePostal(codep);
		System.out.println(grpSocio);
		System.out.println(date);
		personne.setTravaille("medecin");
		personne.setDateNaissance(dn);
		personne.setEmail(email);
		personne.setImagePart(photo);
		personne.setMarie(marie);
		personne.setNationalite(lieuNaissance);
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setNombreEnfant(nbenf);
		if (Sexe.HOMME.name().equals(sexe.toUpperCase())) {
			personne.setSexe(Sexe.HOMME);
		} else {
			personne.setSexe(Sexe.FEMME);
		}
		personne.setTelephone(tel);
		personneRepository.save(personne);
		ConfirmationMessage message = new ConfirmationMessage(personne.getEmail(),
				"Veuillez confirmer votre Inscription en Votre Site preferee de Voyage WIE BATOUTA",
				"CONFIRMATION EMAIL", personne.getPrenom() + " " + personne.getEmail(),
				"/signup/confirmation/" + personne.getCodeVerif()+"/"+personne.getId());
		emailService.sendEmail(message);
		

	}



	public void confirmerSignUP(String codeVerif,Long idPersonne)throws EntityNotFoundException {
		Personne personne = personneRepository.getOne(idPersonne);
		if(personne.getCodeVerif().equals(codeVerif)) {
			 User user = new User();
			 user.setEnabled(false);
			 user.setPassword(personne.getPrenom());
			 user.setUsername(personne.getNom());
			 userRepository.save(user);
		}
	}
}
