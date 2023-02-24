package ma.wiebatouta.models.idcompose;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyReservation implements Serializable,Comparable<KeyReservation> {

	private static final long serialVersionUID = 1L;

	@Column(name = "idVoyage")
	private Long idVoyage;

	@Column(name = "idPerson")
	private Long idPerson;

	@Override
	public int compareTo(KeyReservation o) {
		if(idPerson < o.getIdPerson() && idVoyage < o.getIdVoyage()) {
			return 1;
		}else {
			return -1;
		}
	}

}
