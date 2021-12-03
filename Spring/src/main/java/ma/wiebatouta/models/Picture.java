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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pictures")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture implements Serializable, Comparable<Picture> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "On a besoin d'au moins d'une image")
	@Column(nullable = false)
	private byte[] picture;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@Column(nullable = false)
	private Voyage voyage;

	public Picture(byte[] picture, Voyage voyage) {
		super();
		this.picture = picture;
		this.voyage = voyage;
	}

	@Override
	public int compareTo(Picture o) {
		if (id < o.getId()) {
			return -1;
		} else {
			return 1;
		}
	}

}
