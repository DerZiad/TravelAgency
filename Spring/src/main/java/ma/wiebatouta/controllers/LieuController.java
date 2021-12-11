package ma.wiebatouta.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ma.wiebatouta.controllers.DesignAttributes;

import ma.wiebatouta.metier.LieuxMetier;
import ma.wiebatouta.models.Lieu;

@Controller
@RequestMapping("/lieux")
public class LieuController {
	@Autowired
	private LieuxMetier lm ;
	private final static String PATH_HOTEL = "lieu/addLieu";

	@GetMapping
	@RolesAllowed("ADMIN")
	public ModelAndView listeLieux(){
		ModelAndView model = new ModelAndView(PATH_HOTEL);
		List<Lieu> lieux = lm.listeLieux();
		model.addObject("lieux", lieux);
		model.addObject(DesignAttributes.ACTIVE_HOTEL,DesignAttributes.ACTIVE);

		return model;
		
	}
	
	/*@PostMapping
	@RolesAllowed("ADMIN")
	public Lieu saveLieu(@RequestBody Lieu l) {
		return lm.save(l);
	}*/
}
