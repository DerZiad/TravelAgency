package ma.wiebatouta.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "countryagence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

	@Id
	@Column(length = 2)
	private String keyCountry;

	private String valueCountry;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "country", fetch = FetchType.EAGER, targetEntity = Lieu.class)
	@JsonIgnore
	private List<Lieu> lieux = new ArrayList<Lieu>();

	public Country(String value) {
		super();
		this.valueCountry = value;
	}

	public Country(String keyCountry, String valueCountry) {
		super();
		this.keyCountry = keyCountry;
		this.valueCountry = valueCountry;
	}

}
