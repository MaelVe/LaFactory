package projet.lafactory.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projet.lafactory.dao.IDAOAdmin;
import projet.lafactory.model.Admin;

@Controller
@RequestMapping("/login")
public class LoginController {	
	
	@Autowired
	private IDAOAdmin daoAdmin;
	
	@GetMapping
	public String login(HttpSession session) {		
		return "login";
	}
	
	
	
	@PostMapping()
	public String login(@ModelAttribute Admin admin, HttpServletRequest session, Model model) {
		admin = this.daoAdmin.auth(admin.getMail(), admin.getPassword());
		
		if (admin == null) {
			model.addAttribute("error", true);
			return "redirect:home";
		}
		
		session.setAttribute("utilisateur", admin);
		return "redirect:administration";
		
	}
	
	
	
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
