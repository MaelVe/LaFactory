package projet.lafactory.controller;

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
import projet.lafactory.dao.IDAOOrigami;
import projet.lafactory.dao.IDAOOrigamiCategorie;
import projet.lafactory.origami.Categorie;
import projet.lafactory.origami.Etape;
import projet.lafactory.origami.Origami;
import projet.lafactory.origami.Origami_categorie;

@Controller
@RequestMapping("/choixModifOrigamis")
public class ModifierOrigamiController {
	
		private int idCategorie;
		
		@Autowired
		private IDAOOrigami daoOrigami;
		
		@Autowired
		private IDAOEtapes daoEtape;

		@Autowired
		private IDAOCategorie daoCategorie;

		@Autowired
		private IDAOOrigamiCategorie daoOrigamiCategorie;

		@GetMapping()
		public String get(HttpSession session, Model model) {	
			if (session.getAttribute("utilisateur") == null) {
				return "redirect:login";
			}
			
			model.addAttribute("origamis", this.daoOrigami.findAll());
			
			return "choixModifOrigamis";
		}	
		
		@GetMapping("/modifierOrigami/{id}")
		public String getModif(HttpSession session, Model model,  @PathVariable(value="id") long id) {	
			if (session.getAttribute("utilisateur") == null) {
				return "redirect:login";
			}
			
			model.addAttribute("origami", this.daoOrigami.findById(Math.toIntExact(id)).get());
			model.addAttribute("etapes",this.daoEtape.findByOrigamiId(Math.toIntExact(id)));		
			model.addAttribute("categories",this.daoCategorie.findAll());		
			Origami_categorie cat = this.daoOrigamiCategorie.findIdCategorieByIdOrigami(Math.toIntExact(id));
			model.addAttribute("categorieChosen",this.daoCategorie.findByLongId(Long.valueOf(cat.id_categorie)));
			this.idCategorie = cat.getId(); 
			return "modifierOrigami";
		}	
		
		@PostMapping("/modifierOrigami/{id}")
		public String post(@ModelAttribute Origami origami, @ModelAttribute Etape etape, @ModelAttribute Categorie categorie,  HttpSession session, Model model) {	
			if (session.getAttribute("utilisateur") == null) {
				return "redirect:login";
			}		
			
			Origami org = this.daoOrigami.saveAndFlush(origami);
			
			String[] multipleCategorie = origami.liaisonCatOrg.split(",");				
			
			for (String cat : multipleCategorie) {
				String[] id = cat.split(":");
				int i = Integer.parseInt(id[0].trim());
				
				Origami_categorie oc = new Origami_categorie();
				
				oc.setId(this.idCategorie);
				// Je ne sais pas trop pourquoi la BDD de données à crée 4 champs alors que j'en ai créé que deux
				oc.categories_id = i;
				oc.origami_id = org.id;
				oc.id_categorie = i;
				oc.id_origami = org.id;
				
				this.daoOrigamiCategorie.saveAndFlush(oc);
			}
			
			return "redirect:../home";
		}
}
