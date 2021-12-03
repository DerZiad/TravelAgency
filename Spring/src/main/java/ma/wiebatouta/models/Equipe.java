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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="equipes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Equipe implements Serializable,Comparable<Equipe>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(cascade = {
			CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "equipe", targetEntity = Voyage.class)
	private List<Personne> personnes = new ArrayList<Personne>();
	
	@OneToMany(cascade = {
			CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "equipe", targetEntity = Voyage.class)
	private List<Voyage> voyages = new ArrayList<Voyage>();

	@Override
	public int compareTo(Equipe o) {
		if(id < o.getId()) {
			return 1;
		}else {
			return -1;
		}
	}
}
