package ma.wiebatouta.models;
/**
 * 
 */
import java.io.Serializable;
import java.sql.Date;

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
import ma.wiebatouta.interfaces.Statistique;
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
	
	private long dateCreation = System.currentTimeMillis();
	
	private final static long DELAI = 24 * 3600 * 1000;
		
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
	
	@Override
	public int compareTo(Reservation o) {
		return id.compareTo(o.getId());
	}
	
	public boolean isDead() {
		long dateNow = System.currentTimeMillis();
		if(dateNow >= (dateCreation + DELAI))
			return true;
		else
			return false;
	}
	
}
