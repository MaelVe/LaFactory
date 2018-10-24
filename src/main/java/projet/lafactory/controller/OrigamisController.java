package projet.lafactory.controller;

import javax.servlet.http.HttpSession;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projet.lafactory.dao.IDAOCategorie;
import projet.lafactory.dao.IDAOOrigami;

@Controller
@RequestMapping("/origamis")
public class OrigamisController {

	@Autowired
	private IDAOOrigami daoOrigami;
	
	@GetMapping()
	public String get(@RequestParam long id, Model model) {
		//model.addAttribute("origamis", this.daoOrigami.findById(id).get());
		model.addAttribute("origamis", this.daoOrigami.findByCategorieId(id));
		return "origamis";
	}
	
}
