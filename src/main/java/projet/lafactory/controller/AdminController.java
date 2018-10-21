package projet.lafactory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {	
	@GetMapping({ "/", "/home" })
	public String home(HttpSession session) {
		if (session.getAttribute("utilisateur") == null) {
			return "login";
		}
		
		return "home";
	}
	
	
	
	//@PostMapping({ "/", "/home" })
	//public String login(@ModelAttribute Administrateur admin, HttpSession session, Model model) {
		//admin = this.daoAdmin.auth(admin.getUsername(), admin.getPassword());
		
		//if (admin == null) {
			//model.addAttribute("error", true);
			//return "login";
		//}
		
		//session.setAttribute("utilisateur", admin);
		//return "redirect:home";
	//}
	
	
	
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
