package projet.lafactory.controller;

import java.util.List;

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
import projet.lafactory.dao.IDAOOrigamiCategorie;
import projet.lafactory.origami.Categorie;
import projet.lafactory.origami.Origami_categorie;

@Controller
@RequestMapping("/choixModifCategories")
public class ModifierCategorieController {

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
			
			return "choixModifCategories";
		}	
		
		@GetMapping("/modifierCategorie/{id}")
		public String getModif(HttpSession session, Model model,  @PathVariable(value="id") long id) {	
			if (session.getAttribute("utilisateur") == null) {
				return "redirect:login";
			}
			
			Categorie categorie = this.daoCategorie.findByLongId(id);
			model.addAttribute("categorie", categorie);
			
			return "modifierCategorie";
		}			
		
		@PostMapping("/modifierCategorie/{id}")
		public String post(@ModelAttribute Categorie categorie,  HttpSession session, Model model) {	
			if (session.getAttribute("utilisateur") == null) {
				return "redirect:login";
			}		
			
			List<Origami_categorie> allRelatedCategories = this.daoOrigamiCategorie.findAllyIdCategorie(Math.toIntExact(categorie.id));
			
			this.daoCategorie.saveAndFlush(categorie);
			
			for(Origami_categorie orc : allRelatedCategories){
				this.daoOrigamiCategorie.saveAndFlush(orc);
			}
			
			return "redirect:../../home";
		}
}
