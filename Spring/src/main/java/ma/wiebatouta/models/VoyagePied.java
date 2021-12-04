package ma.wiebatouta.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Voyage Pied")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoyagePied extends Voyage{
	@Column
	private double nbKilometre ;
}
