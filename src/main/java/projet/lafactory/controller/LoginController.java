package projet.lafactory.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projet.lafactory.model.Admin;

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
	
	
	
	@PostMapping()
	public String login(@ModelAttribute Admin admin, HttpServletRequest session, Model model) {
		admin.creationAdmin();
		
		String username = session.getParameter("username");
		String password = session.getParameter("password");
		
		String nameAdmin = admin.getMail();
	
		if(admin.getMail().equals(username) && admin.getPassword().equals(password)) {
			return "redirect:administration";
			
		}
		
		return "redirect:home";
	}
	
	
	
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
