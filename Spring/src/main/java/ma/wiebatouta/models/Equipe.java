package ma.wiebatouta.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="equipes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Equipe implements Serializable,Comparable<Equipe>{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Length(min = 3,max = 20,message = "Le nom de l'equipe doit être entre 3 et 20")
	@NotNull(message = "Vous devez nommer l'equipe")
	private String label;
	
	@OneToOne(cascade = {
			CascadeType.ALL }, fetch = FetchType.EAGER,targetEntity = Personne.class)
	private Personne personne;
	
	@OneToMany(cascade = {
			CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "equipe", targetEntity = Voyage.class)
	@JsonIgnore
	private List<Voyage> voyages = new ArrayList<Voyage>();

	@Override
	public int compareTo(Equipe o) {
		if(voyages.size() < o.getVoyages().size()) {
			return 1;
		}else {
			return -1;
		}
	}
}
