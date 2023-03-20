package br.infnet.edu.at_java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.context.request.WebRequest;

import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.services.UsuarioService;

@SessionAttributes("selected")
@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService _usuario; 
	
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}
	@GetMapping(value = "/logout")
	public String logout(DefaultSessionAttributeStore status, WebRequest request, ModelMap model) {
		model.remove("selected");
	    status.cleanupAttribute(request, "selected");
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST )
	public String Login(@RequestParam String Email,@RequestParam String Password,
			ModelMap model) {
		Usuario logged = _usuario.login(Email, Password);
		if(logged.getId() <= 0) {
			return "login";
		}
		model.put("selected", logged);
		return "main";
		
	}
}
