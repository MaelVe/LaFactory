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

import projet.lafactory.dao.IDAOBoiteAidee;
import projet.lafactory.dao.IDAOCommentaire;
import projet.lafactory.origami.BoiteAidee;
import projet.lafactory.origami.Commentaire;

@Controller
@RequestMapping("/boiteAidee")
public class BoiteAideeController {
	
	
	@Autowired
	private IDAOBoiteAidee daoBoiteAidee;
	
	@GetMapping()
	public String get(HttpSession session) {	
//		if (session.getAttribute("utilisateur") == null) {
//			return "redirect:login";
//		}
		
		return "boiteAidee";
	}
	
	@PostMapping()
	public String ideepost(@ModelAttribute BoiteAidee boiteAidee, HttpServletRequest session, Model model) {	
//		if (session.getAttribute("utilisateur") == null) {
//			return "redirect:login";
//		}
		// Je force à 0 car je le récupère à 1 et du coup il va écraser l'entrée 1 en bdd 
		this.daoBoiteAidee.saveAndFlush(boiteAidee);
		return "redirect:boiteAidee";
	}
}
