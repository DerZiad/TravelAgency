package ma.wiebatouta;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;

import ma.wiebatouta.models.Equipe;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Sexe;
import ma.wiebatouta.models.User;
import ma.wiebatouta.models.enums.ServerRole;
import ma.wiebatouta.repositories.EquipeRepository;
import ma.wiebatouta.repositories.PersonneRepository;
import ma.wiebatouta.repositories.UserRepository;
import ma.wiebatouta.services.ForumCleaner;

@SpringBootApplication
@EnableConfigurationProperties
public class AgenceVoyageApplication implements CommandLineRunner{
	
	@Autowired
	private ForumCleaner forumCleaner;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CountryInitializer countryInitializer;
	
	@Autowired
	private PersonneRepository personneRepository;
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AgenceVoyageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Thread thread = new Thread(forumCleaner);
		thread.start();
		
		List<User> users = userRepository.findAll();
		if(users.size() == 0) {
			User user = new User();
			user.setUsername("twilight");
			user.setPassword(passwordEncoder.encode("twilight"));
			user.addRole(ServerRole.ADMIN);
			userRepository.save(user);
			
			
			Personne person = new Personne();
			person.setCne("D83221dd7");
			person.setNom("Bougrine");
			person.setPrenom("Ziad");
			person.setCodePostal(50000l);
			person.setDateNaissance(new Date("2002/01/02"));
			person.setImage(null);
			person.setEmail("ziadbougrine@gmail.com");
			person.setNationalite("Morroco");
			person.setTravaille("Bachelor");
			person.setNombreEnfant(1);
			person.setSexe(Sexe.HOMME);
			person.setTelephone("+212641408306");
			person.setImage(new byte[] {0});
			User user2 = new User();
			user2.setUsername("ziadbougrine");
			user2.setPassword(passwordEncoder.encode("ziad2002+"));
			user2.addRole(ServerRole.CLIENT);
			person.setUser(user2);
			
			Equipe equipe = new Equipe();
			equipe.setLabel("The eagle");
			equipe.setPersonne(person);
			equipeRepository.save(equipe);
			System.out.println("[ + ] - Admin initialized");
		}else {
			System.out.println("[ + ] - Admin not initialized");
		}
		
		if(countryInitializer.isEmpty()) {
			System.out.println("[ + ] - Remplissage de base de données");
			countryInitializer.remplirBaseDonnee();
		}else {
			System.out.println("[ ! ] - La base de données est plein");
		}
		
		
		
	}

}
