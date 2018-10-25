package projet.lafactory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import projet.lafactory.dao.IDAOEtapes;
import projet.lafactory.dao.IDAOOrigami;
import projet.lafactory.origami.Etape;

@Controller
@RequestMapping("/deleteOrigami")
public class DeleteOrigamiController {

	@Autowired
	private IDAOOrigami daoOrigami;
	
	@Autowired
	private IDAOEtapes daoEtape;
	
	@GetMapping()
	public String get(HttpSession session, Model model) {	
//		if (session.getAttribute("utilisateur") == null) {
//			return "redirect:login";
//		}
		
		model.addAttribute("origamis", this.daoOrigami.findAll());
		
		return "deleteOrigami";
	}
	
	@RequestMapping("/{id}")
	public String delete(@PathVariable(value="id") int id) {	
//		if (session.getAttribute("utilisateur") == null) {
//			return "redirect:login";
//		}		
		
		this.daoOrigami.deleteById(id);
		

		
		
		return "deleteOrigami";
	}
}
