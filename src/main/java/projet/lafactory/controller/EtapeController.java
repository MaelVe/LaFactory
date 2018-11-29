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
import org.springframework.web.bind.annotation.RequestParam;

import projet.lafactory.dao.IDAOCommentaire;
import projet.lafactory.dao.IDAOEtapes;
import projet.lafactory.dao.IDAOOrigami;
import projet.lafactory.origami.Commentaire;
import projet.lafactory.origami.Etape;
import projet.lafactory.origami.Origami;

@Controller
@RequestMapping("/etapes")
public class EtapeController {

	private int origamiId;
	
	@Autowired
	private IDAOEtapes daoEtape;
	
	@Autowired
	private IDAOOrigami daoOrigami;
	
	@Autowired
	private IDAOCommentaire daoCommentaire;
	
	@GetMapping()
	public String get(@RequestParam int id, Model model) {
		//model.addAttribute("etapes", this.daoEtape.findById(id).get());
		model.addAttribute("origami", this.daoOrigami.findById(id).get());
		model.addAttribute("etapes", this.daoEtape.findByOrigamiId(id));
		model.addAttribute("commentaires", this.daoCommentaire.findByOrigamiId(id));
		this.origamiId = id;
		
		// On met à jour le nombre de vue
		Origami org = this.daoOrigami.findById(id).get();
		org.nbVue += 1;	
		this.daoOrigami.saveAndFlush(org);
		
		return "etapes";
	}
	
	@PostMapping()
	public String etape(@ModelAttribute Commentaire commentaire, @ModelAttribute Origami origami, Model model) {	
		
		// Je force à 0 car je le récupère à 1 et du coup il va écraser l'entrée 1 en bdd 
		commentaire.id = 0;
		commentaire.idOrigami = this.origamiId;
		
		// On fait la moyenne des notes
		Origami org = this.daoOrigami.findById(this.origamiId).get();
		org.note = (org.note + origami.note)/2;
		this.daoOrigami.saveAndFlush(org);
		
		this.daoCommentaire.saveAndFlush(commentaire);
		return "redirect:etapes?id="+this.origamiId;
	}
}
