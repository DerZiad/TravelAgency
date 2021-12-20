package ma.wiebatouta.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Feedback")
public class Feedback implements Serializable, Comparable<Feedback> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 255)
	@NotNull(message = "Veuillez ecrire quelque chose ")
	@Length(min = 2, max = 255, message = "Le message doit être entre 2 et 255 caracètres")
	private String message;
	@Length(min = 1, message = "Le nb Etoile doit être 1 ou supérieur à 1")
	private int nbEtoile;
	@Column(nullable = false, length = 20)
	@NotNull(message = "Le titre ne doit pas être vide")
	@Length(min = 2, max = 20, message = "Le titre doit être entre 2 et 20 caracètres")
	private String titre;
	
	@OneToOne
	@JsonIgnore
	private Reservation reservation;
	
	@Override
	public int compareTo(Feedback o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
