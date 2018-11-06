package projet.lafactory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projet.lafactory.dao.IDAOCategorie;
import projet.lafactory.dao.IDAOEtapes;
import projet.lafactory.origami.Etape;
import projet.lafactory.origami.Origami;

@Controller
@RequestMapping("/createEtape")
public class CreateEtapeController {
	
	private int idOrigami;
	private int numEtape;
	
	@Autowired
	private IDAOEtapes daoEtapes;
	
	@GetMapping()
	public String get(HttpSession session) {	
		if (session.getAttribute("utilisateur") == null) {
			return "redirect:login";
		}
		
		return "createEtape";
	}
	
	@RequestMapping("/{id}/{numEtape}")
	public String getWithId(HttpSession session, @PathVariable(value="id") int id, @PathVariable(value="numEtape") int numEtape) {	
		if (session.getAttribute("utilisateur") == null) {
			return "redirect:login";
		}
		this.idOrigami = id;
		this.numEtape = numEtape;
		return "redirect:..";
	}
	
	@PostMapping()
	public String etape(@ModelAttribute Etape etape, HttpServletRequest session, Model model) {	
//		if (session.getAttribute("utilisateur") == null) {
//			return "redirect:login";
//		}
		etape.origami_etapes_id = this.idOrigami;
		etape.numEtape = this.numEtape;
		this.daoEtapes.saveAndFlush(etape);
		this.numEtape++;
		return "redirect:./" + this.idOrigami + "/" + this.numEtape;
	}
	
}
