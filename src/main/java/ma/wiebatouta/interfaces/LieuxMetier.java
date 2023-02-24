package ma.wiebatouta.interfaces;

import java.util.List;

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Lieu;

public interface LieuxMetier {
	public Lieu save(Lieu l);
	public List<Lieu> listeLieux();
	public  Lieu getLieuById(String idLieu) throws NotFoundException;
	public Lieu getLieuById(Long idLieu) throws NotFoundException;
	public void deleteLieu(Long idTheme) ;
}
