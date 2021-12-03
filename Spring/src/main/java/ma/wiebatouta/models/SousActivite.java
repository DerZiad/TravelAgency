package ma.wiebatouta.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sousactivites")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SousActivite implements Serializable,Comparable<SousActivite>{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "description",length = 35,nullable = false)
	@NotNull(message="Le titre ne doit pas être vide")
	@Length(max = 35,min = 5,message="Le titre doit être entre 5 et 35 caractère")
	private String titre;
	
	
	/**
	 * Relations
	 * */
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
	private Activite activite;
	
	public SousActivite(String titre) {
		this.titre = titre;
	}

	@JsonIgnore
	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	@Override
	public int compareTo(SousActivite o) {
		return titre.compareTo(o.getTitre());
	}
	
}
