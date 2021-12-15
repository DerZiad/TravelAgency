package ma.wiebatouta.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ma.wiebatouta.controllers.DesignAttributes;
import ma.wiebatouta.metier.CountryMetier;
import ma.wiebatouta.metier.LieuxMetier;
import ma.wiebatouta.models.Country;
import ma.wiebatouta.models.Lieu;

@Controller
@RequestMapping("/admin/lieux")
public class LieuController {
	private final static String LIEUX ="lieux"; 
	private final static String COUNTRY ="country"; 
	private final static String PATH_HOTEL = "lieu/addLieu";
	private final static String REDIRECT_LIST_LIEUX="redirect:/admin/lieux";
	@Autowired
	private LieuxMetier lm;
	@Autowired
	private CountryMetier cm;

	@GetMapping
	@RolesAllowed("ADMIN")
	public ModelAndView listeLieux() {
		ModelAndView model = new ModelAndView(PATH_HOTEL);
		List<Lieu> lieux = lm.listeLieux();
		model.addObject(LIEUX, lieux);
		List<Country> country = cm.listeCountries();
		model.addObject(DesignAttributes.ACTIVE_LIEUX_AJOUT, DesignAttributes.ACTIVE);
		model.addObject(COUNTRY, country);
		return model;

	}



	@PostMapping
	@RolesAllowed("ADMIN")
	public ModelAndView saveLieu(@RequestParam("name") String name, @RequestParam("keycountry") String keyCountry) {
		Lieu lieu = new Lieu();
		Country country =cm.getCountryByKey(keyCountry);
		lieu.setLabel(name);
		lieu.setCountry(country);
		lm.save(lieu);
		ModelAndView model = new ModelAndView(REDIRECT_LIST_LIEUX);
		return model;
	}
}
