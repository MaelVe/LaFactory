package projet.lafactory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projet.lafactory.dao.IDAOCategorie;
import projet.lafactory.model.Admin;
import projet.lafactory.origami.Categorie;

@Controller
@RequestMapping("/createCategorie")
public class CreateCategorieController {
	@Autowired
	private IDAOCategorie daoCategorie;
	
	@GetMapping()
	public String get(HttpSession session, Model model) {	
//		if (session.getAttribute("utilisateur") == null) {
//			return "redirect:login";
//		}
		model.addAttribute("categories", this.daoCategorie.findAll());
		return "createCategorie";
	}
	
	@PostMapping()
	public String post(@ModelAttribute Categorie categorie, Model model) {	
//		if (session.getAttribute("utilisateur") == null) {
//			return "redirect:login";
//		}
		this.daoCategorie.saveAndFlush(categorie);
		return "createCategorie";
	}
	
}
