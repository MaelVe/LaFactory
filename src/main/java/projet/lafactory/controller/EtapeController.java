package projet.lafactory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projet.lafactory.dao.IDAOEtapes;
import projet.lafactory.dao.IDAOOrigami;

@Controller
@RequestMapping("/etapes")
public class EtapeController {

	@Autowired
	private IDAOEtapes daoEtape;
	
	@Autowired
	private IDAOOrigami daoOrigami;
	
	@GetMapping()
	public String get(@RequestParam int id, Model model) {
		//model.addAttribute("etapes", this.daoEtape.findById(id).get());
		model.addAttribute("origami", this.daoOrigami.findById(id).get());
		model.addAttribute("etapes", this.daoEtape.findByOrigamiId(id));
		return "etapes";
	}
}
