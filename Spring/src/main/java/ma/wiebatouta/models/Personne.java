package ma.wiebatouta.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cne;
	
	@Column(nullable = false)
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private int codePostal;
	private String travaille;
	private int nombreEnfant;
	private String nationalité;
	private boolean marie = false;
	private String lieuNaissance;
	private String etatSocial;
	
	
	
	
}
