package ma.wiebatouta.metier;

import java.util.List;

import ma.wiebatouta.models.Country;

public interface CountryMetier {
	public List<Country> listeCountries();
	public Country getCountryByKey(String key);
}
