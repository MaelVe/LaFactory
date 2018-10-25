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
import projet.lafactory.model.Admin;
import projet.lafactory.origami.Origami;

@Controller
@RequestMapping("/createOrigami")
public class CreateOrigamiController {

	@Autowired
	private IDAOOrigami daoOrigami;
	@Autowired
	private IDAOCategorie daoCategorie;
	
	@GetMapping()
	public String get(HttpSession session, Model model) {	
//		if (session.getAttribute("utilisateur") == null) {
//			return "redirect:login";
//		}
		model.addAttribute("categories", this.daoCategorie.findAll());
		
		return "createOrigami";
	}
	
	@PostMapping()
	public String post(@ModelAttribute Origami origami, HttpServletRequest session, Model model) {	
//		if (session.getAttribute("utilisateur") == null) {
//			return "redirect:login";
//		}
		
		origami.activate =true;
		origami.note = 0;
		origami.nbVue = 0;
		this.daoOrigami.saveAndFlush(origami);		
		return "createEtape";
	}
}
