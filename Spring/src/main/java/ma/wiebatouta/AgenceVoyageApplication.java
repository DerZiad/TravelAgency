package ma.wiebatouta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class AgenceVoyageApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenceVoyageApplication.class, args);
	}

}
