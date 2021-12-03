package ma.wiebatouta.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voyage {
	
	private Long id;
	private Date ageMax;
	private Date ageMin;
	private Date dateArrivee;
	private Date dateDepart;
	private String description;
	private int nombrePersonneEnGroupe;
	private int nombrePersonneTotal;
	private double prix;
	private boolean reduction;
	private String titre;
	private byte[] trajet;
}
