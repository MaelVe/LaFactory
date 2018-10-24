package projet.lafactory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/createCategorie")
public class CreateCategorieController {

	@GetMapping()
	public String get(HttpSession session) {	
//		if (session.getAttribute("utilisateur") == null) {
//			return "redirect:login";
//		}
		
		return "createCategorie";
	}
	
}
