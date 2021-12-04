package ma.wiebatouta.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personnes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personne implements Serializable, Comparable<Personne> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 15)
	@Length(min = 3, max = 15, message = "Le cne doit être entre 3 et 15 caractères")
	@NotNull(message = "Le cne ne doit pas être null")
	private String cne;
	@Column(nullable = false, length = 20)
	@NotNull(message = "Le nom ne doit pas être vide")
	@Length(min = 2, max = 20, message = "Le nom doit être entre 2 et 20 caracètres")
	private String nom;
	@Column(nullable = false, length = 20)
	@NotNull(message = "Le prenom ne doit pas être vide")
	@Length(min = 2, max = 20, message = "Le prenom doit être entre 2 et 20 caracètres")
	private String prenom;
	@Past(message = "La date de naissance doît être dans le passé")
	@NotNull(message = "La date de naissance ne doît pas être vide")
	private Date dateNaissance;
	@NotNull(message = "Le code postal ne doît pas être vide")
	private int codePostal;
	@Column(nullable = false, length = 40)
	@NotNull(message = "Le travaille ne doit pas être vide")
	@Length(min = 5, max = 40, message = "Le travaille doit être entre 5 et 40 caracètres")
	private String travaille;
	@Column(nullable = false)
	@NotNull(message = "Le nombre d'enfants ne doit pas être vide")
	@Length(min = 0, max = 10, message = "Le nombre d'enfants doit être entre 0 et 10")
	private int nombreEnfant;
	@Column(nullable = false, length = 25)
	@NotNull(message = "La nationnalité ne doit pas être vide")
	@Length(min = 5, max = 25, message = "La nationnalité doit être entre 5 et 25 caracètres")
	private String nationalité;
	private boolean marie = false;
	@Column(nullable = false, length = 35)
	@NotNull(message = "Lieu de naissance ne doit pas être vide")
	@Length(min = 4, max = 35, message = "Lieu de naissance doit être entre 4 et 35 caracètres")
	private String lieuNaissance;
	@Column(nullable = false, length = 35)
	@NotNull(message = "L'etat social ne ne doit pas être vide")
	@Length(min = 2, max = 25, message = "L'etat social doit être entre 2 et 25 caracètres")
	private String etatSocial;

	/*
	 * Relations
	 **/

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH })
	@JsonIgnore
	private List<Voyage> voyages = new ArrayList<Voyage>();

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Equipe equipe = null;
	
	@OneToMany(cascade= {CascadeType.ALL},mappedBy = "person")
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	@Override
	public int compareTo(Personne o) {
		return cne.compareTo(o.getCne());
	}

}
