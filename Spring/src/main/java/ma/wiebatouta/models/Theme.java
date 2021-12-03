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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "themes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theme implements Serializable, Comparable<Theme> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "label", nullable = false, length = 60)
	@NotNull(message = "Le label d'un theme ne doit pas être vide")
	@Length(min = 5, max = 60, message = "Le label doit être entre 5 et 60")
	private String label;
	
	@ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE},fetch = FetchType.LAZY)
	private Voyage voyage;

	public Theme(String label,Voyage voyage) {
		super();
		this.label = label;
		this.voyage = voyage;
	}

	@Override
	public int compareTo(Theme o) {
		return label.compareTo(o.getLabel());
	}

}
