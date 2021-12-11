package ma.wiebatouta.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "voyages")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="TYPE_VOYAGE",discriminatorType = DiscriminatorType.STRING)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voyage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 150)
	@Length(min = 1, max = 150, message = "L'age est entre 1 et 150 maximum")
	private Integer ageMax;
	@Column(length = 150)
	@Length(min = 1, max = 150, message = "L'age est entre 1 et 150 minimum")
	private Integer ageMin;
	@NotNull(message = "La date d'arrivée ne doit pas être vide")
	@Future(message = "La date d'arrivée ne doit pas être dans le passé")
	private Date dateArrivee;
	@NotNull(message = "La date de départ ne doit pas être vide")
	@Future(message = "La date de départ ne doit pas être dans le passé")
	private Date dateDepart;
	@Column(length = 600)
	@NotNull(message = "La description ne doit pas être vide")
	@Length(min = 9, max = 600, message = "La description doît être entre 9 et 600")
	private String description;
	@Length(min = 1, message = "Le nombre de personne en groupe doît être au moins 1")
	private int nombrePersonneEnGroupe;
	@Length(min = 0, message = "Le nombre de personne en groupe doît être au moins 1")
	private int nombrePersonneTotal;
	@Length(min = 0, message = "Le prix doit être 0 ou supérieur à 0")
	private double prix;
	private boolean reduction = false;
	@Column(length = 45)
	@NotNull(message = "Le titre de voyage est important")
	@Length(min = 5, max = 45, message = "Le titre de voyage doît être entre 5 et 45")
	private String titre;
	@NotNull(message = "Le trajet ne doit pas être vide")
	private byte[] trajet;
	@Column
	private double nbKilometres;
	@Column
	private int nbrPersonnes;
	/**
	 * Relations
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE,
			CascadeType.DETACH }, mappedBy = "voyages")
	@JsonIgnore
	private List<Hotel> hoteles = new ArrayList<Hotel>();

	/*@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "voyage", targetEntity = Theme.class)
	private List<Theme> themes = new ArrayList<Theme>();*/

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "voyage", targetEntity = Picture.class)
	private List<Picture> pictures = new ArrayList<Picture>();

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "voyage", targetEntity = Activite.class)
	private List<Activite> activites = new ArrayList<Activite>();

	/*@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "voyage", targetEntity = Lieu.class)
	private List<Lieu> lieux = new ArrayList<Lieu>();*/

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE,
			CascadeType.DETACH }, mappedBy = "voyages", targetEntity = Personne.class)
	private List<Personne> personnes = new ArrayList<Personne>();

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH })
	@JsonIgnore
	private Equipe equipe;

	
	@OneToMany(cascade= {CascadeType.ALL},mappedBy = "voyage")
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	public Voyage(Integer ageMax, Integer ageMin, Date dateArrivee, Date dateDepart, String description,
			int nombrePersonneEnGroupe, int nombrePersonneTotal, double prix, boolean reduction, String titre,
			byte[] trajet) {
		super();
		this.ageMax = ageMax;
		this.ageMin = ageMin;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.description = description;
		this.nombrePersonneEnGroupe = nombrePersonneEnGroupe;
		this.nombrePersonneTotal = nombrePersonneTotal;
		this.prix = prix;
		this.reduction = reduction;
		this.titre = titre;
		this.trajet = trajet;
	}

}
