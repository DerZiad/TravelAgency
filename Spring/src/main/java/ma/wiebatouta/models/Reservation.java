package ma.wiebatouta.models;
/**
 * 
 */
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.wiebatouta.models.idcompose.KeyReservation;

@Entity
@Table(name="reservations")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation implements Serializable,Comparable<Reservation>,Statistique{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private KeyReservation id = new KeyReservation();
	
	@Column
	boolean isConfirmed = false;
	
	@Column
	boolean isReserved = false;
	
	/**
	 * Relations
	 * */
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
	@MapsId("idVoyage")
	private Voyage voyage;
	
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
	@MapsId("idPerson")
	private Personne person;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Feedback feedback = new Feedback();
	
	@Override
	public int compareTo(Reservation o) {
		return id.compareTo(o.getId());
	}

}
