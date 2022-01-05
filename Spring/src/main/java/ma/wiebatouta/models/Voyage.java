package ma.wiebatouta.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.wiebatouta.models.enums.TypePicture;
import ma.wiebatouta.models.enums.TypeVoyage;

@Entity
@Table(name = "voyages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voyage implements Comparable<Voyage> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 150)
	@Range(min = 1, max = 150, message = "L'age est entre 1 et 150 maximum")
	private Integer ageMax;
	@Column(length = 150)
	@Range(min = 1, max = 150, message = "L'age est entre 1 et 150 minimum")
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
	@Range(min = 0, message = "Le nombre de personne en groupe doît être au moins 1")
	private int nombrePersonneTotal;
	@Range(min = 0, message = "Le prix doit être 0 ou supérieur à 0")
	private double prix;
	private double reduction = 0;
	@Column(length = 45)
	@NotNull(message = "Le titre de voyage est important")
	@Length(min = 5, max = 45, message = "Le titre de voyage doît être entre 5 et 45")
	private String titre;
	@Column
	private double nbKilometres;
	@Column
	private int nbrPersonnes = 0;
	@Column
	private String destination;

	@Transient
	private Long idEquipe;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Le type voyage ne doit pas être vide")
	private TypeVoyage typeVoyage;
	private int review = 0;

	/**
	 * Relations
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH }, mappedBy = "voyages")
	private List<Hotel> hoteles = new ArrayList<Hotel>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.DETACH }, mappedBy = "voyages", targetEntity = Theme.class, fetch = FetchType.LAZY)
	private List<Theme> themes = new ArrayList<Theme>();

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "voyage", targetEntity = Picture.class)
	private List<Picture> pictures = new ArrayList<Picture>();

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "voyage", targetEntity = Activite.class)
	private List<Activite> activites = new ArrayList<Activite>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.DETACH }, mappedBy = "voyages", targetEntity = Lieu.class)
	private List<Lieu> lieux = new ArrayList<Lieu>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.DETACH }, mappedBy = "voyages", targetEntity = Personne.class)
	@JsonIgnore
	private List<Personne> personnes = new ArrayList<Personne>();

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH })
	private Equipe equipe;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "voyage")
	@JsonIgnore
	private List<Reservation> reservations = new ArrayList<Reservation>();

	@SuppressWarnings("deprecation")
	public void setDateDepartDate(String date) {
		if (date != null && date.length() == 10) {
			date = date.replace("-", "/");
			this.dateDepart = new Date(date);
		} else {
			date = null;
		}
	}

	@SuppressWarnings("deprecation")
	public void setDateArriveeDate(String date) {
		if (date != null && date.length() == 10) {
			date = date.replace("-", "/");
			this.dateArrivee = new Date(date);
		} else {
			date = null;
		}
	}

	public String getDateArriveeDate() {
		java.sql.Date sDate = new java.sql.Date(this.dateArrivee.getTime());
		return sDate.toString();
	}

	public String getDateDepartDate() {
		java.sql.Date sDate = new java.sql.Date(this.dateDepart.getTime());
		return sDate.toString();
	}

	public void addLieu(Lieu lieu) {
		lieux.add(lieu);
	}

	public String getHeader() {
		List<Picture> pictures = this.pictures.stream().filter((p) -> {
			return p.getType().equals(TypePicture.HEADER);
		}).collect(Collectors.toList());

		if (pictures.size() >= 1) {
			return pictures.get(0).getBase64();
		} else {
			return "";
		}
	}

	public String getBanner() {
		List<Picture> pictures = this.pictures.stream().filter((p) -> {
			return p.getType().equals(TypePicture.BANNER);
		}).collect(Collectors.toList());

		if (pictures.size() >= 1) {
			return pictures.get(0).getBase64();
		} else {
			return "";
		}
	}

	@Override
	public int compareTo(Voyage o) {
		return review - o.getReview();
	}

	public boolean isSolded() {
		if (reduction == 0) {
			return false;
		} else {
			return true;
		}
	}

	public double getReductionPrix() {
		double prix = this.prix - (this.prix * this.reduction / 100);
		return prix;
	}

}
