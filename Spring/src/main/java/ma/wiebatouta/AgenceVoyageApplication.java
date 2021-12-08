package ma.wiebatouta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;

import ma.wiebatouta.models.User;
import ma.wiebatouta.models.enums.ServerRole;
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
			System.out.println("[ + ] - Admin initialized");
		}else {
			System.out.println("[ + ] - Admin not initialized");
		}
	}

}
