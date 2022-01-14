package ma.wiebatouta.metier;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.User;
import ma.wiebatouta.models.enums.ServerRole;
import ma.wiebatouta.repositories.PersonneRepository;
import ma.wiebatouta.repositories.UserRepository;
import ma.wiebatouta.services.EmailService;

@Service
public class SignUpMetier {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private PersonneRepository personneRepository;

	@Autowired
	private EmailService emailService;

	@Autowired
	private UserRepository userRepository;

	public void createSignUp(Personne personne) throws IOException, MessagingException {
		User user = new User();
		user.setEnabled(false);
		user.setPassword(passwordEncoder.encode(personne.getNom().toLowerCase() + "." + personne.getPrenom().toLowerCase()));
		user.setUsername(personne.getNom().toLowerCase() + "." + personne.getPrenom().toLowerCase());
		user.addRole(ServerRole.CLIENT);
		personne.setUser(user);
		personne.generateCode();
		personneRepository.save(personne);
		ConfirmationMessage	message = new ConfirmationMessage(personne.getEmail(),
				"Veuillez confirmer votre Inscription en Votre Site preferee de Voyage WIE BATOUTA",
				"CONFIRMATION EMAIL", personne.getPrenom() + " " + personne.getNom(),
				"/signup/confirmation/" + personne.getCodeVerif() + "/" + personne.getId());
		emailService.sendEmail(message);
	}

	public void confirmerSignUP(String codeVerif, Long idPersonne) throws EntityNotFoundException, NotFoundException {
		Personne personne = personneRepository.findById(idPersonne)
				.orElseThrow(() -> new NotFoundException("Personne non trouvé"));
		if (personne.getCodeVerif().equals(codeVerif)) {
			User user = personne.getUser();
			user.setEnabled(true);
			userRepository.save(user);
		}
	}
}
