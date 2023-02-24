package ma.wiebatouta.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.interfaces.LieuxMetier;
import ma.wiebatouta.models.Lieu;
import ma.wiebatouta.repositories.LieuRepository;

@Service
public class LieuxMetierIMP implements LieuxMetier {
	
	@Autowired
	private LieuRepository lieuRepository ;
	
	@Override
	public Lieu save(Lieu l) {
		// TODO Auto-generated method stub
		return lieuRepository.save(l);
	}

	@Override
	public List<Lieu> listeLieux() {
		// TODO Auto-generated method stub
		return lieuRepository.findAll();
	}

	@Override
	public Lieu getLieuById(String idLieu) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lieu getLieuById(Long idLieu) throws NotFoundException {
		// TODO Auto-generated method stub
		Lieu lieu = lieuRepository.findById(idLieu).orElseThrow(()-> new NotFoundException());
		return lieu ;
	}

	@Override
	public void deleteLieu(Long idLieu) {
		// TODO Auto-generated method stub
		lieuRepository.deleteById(idLieu);
	}

}
