package ma.wiebatouta.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Voyage familiale")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoyageFamiliale extends Voyage{
	@Column
	private int nbMembres ;
}
