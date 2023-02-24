package ma.wiebatouta.metier;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.interfaces.ThemeMetierInterface;
import ma.wiebatouta.models.Theme;
import ma.wiebatouta.repositories.ThemeRepository;

@Service
public class ThemeMetierIMP implements ThemeMetierInterface {
	@Autowired
	private ThemeRepository themeRepository ;
	
	
	@Override
	public Theme save(Theme theme) throws IOException {
		theme.encodeAll();
		return themeRepository.save(theme);
	}

	@Override
	public List<Theme> liseThemes() {
		// TODO Auto-generated method stub
		return themeRepository.findAll();
	}

	@Override
	public Theme getThemeById(String idTheme) throws NotFoundException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(idTheme);
		Theme t = themeRepository.findById(id).orElseThrow(()-> new NotFoundException());
		return t ;
	}

	@Override
	public Theme getThemeById(Long idTheme) throws NotFoundException {
		Theme t = themeRepository.findById(idTheme).orElseThrow(()-> new NotFoundException());
		return t ;
	}

	@Override
	public void deleteTheme(Long idTheme) {
		// TODO Auto-generated method stub
		themeRepository.deleteById(idTheme);
		}



}
