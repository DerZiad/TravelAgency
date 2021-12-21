package ma.wiebatouta;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ma.wiebatouta.models.Equipe;
import ma.wiebatouta.models.Personne;
import ma.wiebatouta.models.Sexe;
import ma.wiebatouta.repositories.EquipeRepository;

@SpringBootTest
public class CreateEquipe {
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	@Test
	public void createEquipe() {

	}
}
