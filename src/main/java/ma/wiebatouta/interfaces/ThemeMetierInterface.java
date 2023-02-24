package ma.wiebatouta.interfaces;

import java.io.IOException;
import java.util.List;

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Theme;

public interface ThemeMetierInterface {
	public List<Theme> liseThemes();
	public Theme save(Theme theme) throws IOException;
	public  Theme getThemeById(String idTheme) throws NotFoundException;
	public Theme getThemeById(Long idTheme) throws NotFoundException;
	public void deleteTheme(Long idTheme) ;
}
