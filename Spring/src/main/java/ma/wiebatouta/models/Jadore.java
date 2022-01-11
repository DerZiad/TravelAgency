package ma.wiebatouta.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.wiebatouta.models.idcompose.KeyLike;
import ma.wiebatouta.models.idcompose.KeyReservation;

@Entity
@Table(name="jadores")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Jadore {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private KeyLike id = new KeyLike();	
		
	/**
	 * Relations
	 * */
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
	@MapsId("idVoyage")
	private Voyage voyage;
	
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
	@MapsId("idPerson")
	private Personne person;
	
	@Transient
	private Long idPerson;
	
	@Transient
	private Long idVoyage;
	
}
