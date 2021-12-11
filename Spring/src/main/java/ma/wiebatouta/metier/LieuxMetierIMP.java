package ma.wiebatouta.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.wiebatouta.models.Lieu;
import ma.wiebatouta.repositories.LieuRepository;

@Service
public class LieuxMetierIMP implements LieuxMetier {
	
	@Autowired
	private LieuRepository lr ;
	
	@Override
	public Lieu save(Lieu l) {
		// TODO Auto-generated method stub
		return lr.save(l);
	}

	@Override
	public List<Lieu> listeLieux() {
		// TODO Auto-generated method stub
		return lr.findAll();
	}

}
