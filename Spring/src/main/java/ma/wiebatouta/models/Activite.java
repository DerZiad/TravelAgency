package ma.wiebatouta.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activites")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activite implements Serializable, Comparable<Activite> {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nomactivite", nullable = false, length = 60)
	@Length(min = 5, max = 60, message = "La taille du titre d'activite doit être entre 5 et 60 caractères")
	@NotNull(message = "Le nom d'activite ne doit pas être vide")
	private String nomActivite;
	@Column(name = "description", nullable = false, length = 150)
	@NotNull(message = "La description ne doit pas être vide")
	@Length(min = 5, max = 150, message = "La taille de la description d'activite doit être entre 5 et 150 caractères")
	private String description;

	/**
	 * Relations
	 */
	@OneToMany(cascade = {
			CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "activite", targetEntity = SousActivite.class)
	private List<SousActivite> sousActivites = new ArrayList<SousActivite>();

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JsonIgnore
	private Voyage voyage;

	public Activite(String nomActivite, String description, Voyage voyage) {
		super();
		this.nomActivite = nomActivite;
		this.description = description;
		 this.voyage = voyage;
	}

	@Override
	public int compareTo(Activite o) {
		return this.nomActivite.compareTo(o.getNomActivite());
	}

	public Activite(Long id,
			@Length(min = 20, max = 60, message = "La taille du titre d'activite doit être entre 20 et 60 caractères") @NotNull(message = "Le nom d'activite ne doit pas être vide") String nomActivite,
			@NotNull(message = "La description ne doit pas être vide") @Length(min = 50, max = 150, message = "La taille de la description d'activite doit être entre 50 et 150 caractères") String description,
			List<SousActivite> sousActivites) {
		super();
		this.id = id;
		this.nomActivite = nomActivite;
		this.description = description;
		this.sousActivites = sousActivites;
	}

	public Activite(Long id,
			@Length(min = 20, max = 60, message = "La taille du titre d'activite doit être entre 20 et 60 caractères") @NotNull(message = "Le nom d'activite ne doit pas être vide") String nomActivite,
			@NotNull(message = "La description ne doit pas être vide") @Length(min = 50, max = 150, message = "La taille de la description d'activite doit être entre 50 et 150 caractères") String description) {
		super();
		this.id = id;
		this.nomActivite = nomActivite;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Activite [id=" + id + ", nomActivite=" + nomActivite + ", description=" + description
				+ ", sousActivites=" + sousActivites + ", voyage=" + voyage + "]";
	}
	

}
