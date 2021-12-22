package ma.wiebatouta.models;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

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
	private Long codePostal;
	@Column(nullable = false, length = 40)
	@NotNull(message = "Le travaille ne doit pas être vide")
	@Length(min = 5, max = 40, message = "Le travaille doit être entre 5 et 40 caracètres")
	private String travaille;
	@Column(nullable = false)
	@NotNull(message = "Le nombre d'enfants ne doit pas être vide")
	@Range(min = 0, max = 10, message = "Le nombre d'enfants doit être entre 0 et 10")
	private Integer nombreEnfant;
	@Column(nullable = false, length = 25)
	@NotNull(message = "La nationnalité ne doit pas être vide")
	@Length(min = 5, max = 25, message = "La nationnalité doit être entre 5 et 25 caracètres")
	private String nationalite;
	private boolean marie = false;
	@Column(nullable = false, length = 35)
	@NotNull(message = "L'etat social ne ne doit pas être vide")
	@Length(min = 2, max = 25, message = "L'etat social doit être entre 2 et 25 caracètres")
	private String etatSocial;
	@Length(min = 10, max = 22, message = "Le numéro de téléphone doit être entre 10 et 22")
	@NotNull(message = "Le numero de téléphone ne doit pas être vide")
	private String telephone;
	@Email(message = "L'email n'est pas valide")
	private String email;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Le sexe ne doit pas être vide")
	private Sexe sexe;

	@Lob
	@NotNull(message = "L'immage ne doit pas être vide")
	private byte[] image;
	/*
	 * Relations
	 **/

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH })
	@JsonIgnore
	private List<Voyage> voyages = new ArrayList<Voyage>();

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "person")
	@JsonIgnore
	private List<Reservation> reservations = new ArrayList<Reservation>();

	@Override
	public int compareTo(Personne o) {
		return cne.compareTo(o.getCne());
	}

	@SuppressWarnings("deprecation")
	public void setDateNaissanceDate(String date) {
		if (date != null && date.length() == 10) {
			date = date.replace("-", "/");
			this.dateNaissance = new Date(date);
		} else {
			date = null;
		}
	}

	public void setMarieString(String marie) {
		if (marie.equals("OUI")) {
			this.marie = true;
		} else {
			this.marie = false;
		}
	}

	public void setImagePart(MultipartFile file) throws IOException {
		byte image[] = file.getBytes();
		if (image != null && image.length != 0) {
			this.image = image;
		} else {
			this.image = null;
		}
	}

	public String getBase64() {
		String c = "";
		if (this.image != null && this.image.length != 0) {
			c = Base64.getEncoder().encodeToString(this.image);
		}
		return c;
	}

	public String getDateNaissanceDate() {
		java.sql.Date sDate = new java.sql.Date(this.dateNaissance.getTime());
		return sDate.toString();
	}

}
