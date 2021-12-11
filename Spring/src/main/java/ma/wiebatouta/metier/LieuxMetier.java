package ma.wiebatouta.metier;

import java.util.List;

import ma.wiebatouta.models.Lieu;

public interface LieuxMetier {
	public Lieu save(Lieu l);
	public List<Lieu> listeLieux();
}
