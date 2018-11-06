package projet.lafactory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projet.lafactory.dao.IDAOAdmin;
import projet.lafactory.dao.IDAOCategorie;
import projet.lafactory.dao.IDAOOrigami;
import projet.lafactory.dao.IDAOOrigamiCategorie;
import projet.lafactory.model.Admin;
import projet.lafactory.origami.Origami;
import projet.lafactory.origami.Origami_categorie;

@Controller
@RequestMapping("/createOrigami")
public class CreateOrigamiController {

	@Autowired
	private IDAOOrigami daoOrigami;
	@Autowired
	private IDAOCategorie daoCategorie;
	@Autowired
	private IDAOOrigamiCategorie daoOrigamiCategorie;
	
	@GetMapping()
	public String get(HttpSession session, Model model) {	
		if (session.getAttribute("utilisateur") == null) {
			return "redirect:login";
		}
		
		model.addAttribute("categories", this.daoCategorie.findAll());
		
		return "createOrigami";
	}
	
	@PostMapping()
	public String post(@ModelAttribute Origami origami, HttpServletRequest session, Model model) {	
		if (session.getAttribute("utilisateur") == null) {
			return "redirect:login";
		}	
		
		origami.note = 0;
		origami.nbVue = 0;		
		
		Origami org = this.daoOrigami.saveAndFlush(origami);	
		String[] multipleCategorie = origami.liaisonCatOrg.split(",");
		
		
		
		for (String cat : multipleCategorie) {
			String[] id = cat.split(":");
			int i = Integer.parseInt(id[0].trim());
			
			Origami_categorie oc = new Origami_categorie();
			// Je ne sais pas trop pourquoi la BDD de données à crée 4 champs alors que j'en ai créé que deux
			oc.categories_id = i;
			oc.origami_id = org.id;
			oc.id_categorie = i;
			oc.id_origami = org.id;
			
			this.daoOrigamiCategorie.saveAndFlush(oc);
		}
		
		return "redirect:createEtape/"+org.id+"/1";
	}
}
