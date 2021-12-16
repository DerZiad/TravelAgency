package ma.wiebatouta.metier;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.multipart.MultipartFile;

import ma.wiebatouta.exceptions.NotFoundException;
import ma.wiebatouta.models.Theme;

public interface ThemeMetierInterface {
	public List<Theme> liseThemes();
	public Theme save(Theme theme) throws IOException;
	public  Theme getThemeById(String idTheme) throws NotFoundException;
	public Theme getThemeById(Long idTheme) throws NotFoundException;
	public void deleteTheme(Long idTheme) ;
}
