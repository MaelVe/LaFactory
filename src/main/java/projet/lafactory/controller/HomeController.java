package projet.lafactory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import projet.lafactory.dao.IDAOCategorie;
import projet.lafactory.model.Admin;

@Controller
public class HomeController {
	@Autowired
	private IDAOCategorie daoCategorie;
	
	@GetMapping({ "/", "/home" })
	public String home(HttpSession session, Model model) {
		model.addAttribute("categories", this.daoCategorie.findAll());
		//model.addAttribute("sousCcategories", this.daoCategorie.findSubCategories());;	
		return "home";
	}	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:home";
	}	
	
	@ModelAttribute("isPageHomeActive")
	public boolean isPageHomeActive() {
		return true;
	}
}
