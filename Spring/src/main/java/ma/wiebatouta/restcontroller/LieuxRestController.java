package ma.wiebatouta.restcontroller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.metier.LieuxMetier;
import ma.wiebatouta.models.Lieu;

@RestController
@RequestMapping("/api/lieux")
public class LieuxRestController {
	@Autowired
	private LieuxMetier lm ;
	
	@GetMapping
	@RolesAllowed("ADMIN")
	public ModelAndView listeLieux(){
		ModelAndView model = new ModelAndView("/hotel/index");
		List<Lieu> lieux = lm.listeLieux();
		model.addObject("lieux", lieux);
		return model;
		
	}
	
	@PostMapping
	@RolesAllowed("ADMIN")
	public Lieu saveLieu(@RequestBody Lieu l) {
		return lm.save(l);
	}
	
	
}
