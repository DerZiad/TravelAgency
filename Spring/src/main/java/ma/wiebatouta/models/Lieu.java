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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lieux")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lieu implements Serializable, Comparable<Lieu> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "label", length = 35)
	@NotNull(message = "Le nom de lieu ne doit pas être vide ")
	@Length(min = 4, max = 35, message = "le nom de lieu doit être entre 4 et 35")
	private String label;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private List<Voyage> voyages = new ArrayList<Voyage>();

	public Lieu(String label, List<Voyage> voyages) {
		super();
		this.label = label;
		this.voyages = voyages;
	}

	@Override
	public int compareTo(Lieu o) {
		return label.compareTo(o.getLabel());
	}

}
