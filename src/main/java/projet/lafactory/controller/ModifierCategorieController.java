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
import projet.lafactory.origami.Categorie;

@Controller
@RequestMapping("/choixModifCategories")
public class ModifierCategorieController {

		@Autowired
		private IDAOCategorie daoCategorie;

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
			
			this.daoCategorie.saveAndFlush(categorie);
			return "redirect:../home";
		}
}
