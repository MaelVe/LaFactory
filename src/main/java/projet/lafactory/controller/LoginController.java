package projet.lafactory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {	
	@GetMapping
	public String login(HttpSession session) {
		//if (session.getAttribute("utilisateur") == null) {
			//return "login";
		//}
		
		return "login";
	}
	
	
	
	//@PostMapping({ "/", "/home" })
	//public String login(@ModelAttribute Admin admin, HttpSession session, Model model) {
		//admin = this.daoAdmin.auth(admin.getUsername(), admin.getPassword());
		
		//if (admin == null) {
			//model.addAttribute("error", true);
			//return "login";
		//}
		
		//session.setAttribute("utilisateur", admin);
		//return "redirect:home";
	//}
	
	
	
	@GetMapping("/logout")
	public String logou(HttpSession session) {
		session.invalidate();
		return "redirect:home";
	}	
	
	@ModelAttribute("isPageHomeActive")
	public boolean isPageHomeActiv() {
		return true;
	}
}
