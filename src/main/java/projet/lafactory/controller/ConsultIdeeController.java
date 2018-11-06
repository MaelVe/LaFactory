package projet.lafactory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projet.lafactory.dao.IDAOBoiteAidee;

@Controller
@RequestMapping("/consultIdee")
public class ConsultIdeeController {

	
	@Autowired
	private IDAOBoiteAidee daoBoiteAidee;
	
	@GetMapping()
	public String get(HttpSession session, Model model) {	
		if (session.getAttribute("utilisateur") == null) {
			return "redirect:login";
		}
		model.addAttribute("idees", this.daoBoiteAidee.findAll());
		return "consultIdee";
	}
}
