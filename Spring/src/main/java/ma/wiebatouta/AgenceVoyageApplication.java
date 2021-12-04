package ma.wiebatouta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import ma.wiebatouta.services.ForumCleaner;

@SpringBootApplication
@EnableConfigurationProperties
public class AgenceVoyageApplication implements CommandLineRunner{
	
	@Autowired
	private ForumCleaner forumCleaner;
	
	public static void main(String[] args) {
		SpringApplication.run(AgenceVoyageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Thread thread = new Thread(forumCleaner);
		thread.start();
	}

}
