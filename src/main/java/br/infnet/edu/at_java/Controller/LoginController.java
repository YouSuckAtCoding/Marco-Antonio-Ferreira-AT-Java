package br.infnet.edu.at_java.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.Utility.ValidateLogin;
import br.infnet.edu.at_java.repositories.UsuarioRepository;

@SessionAttributes("selected")
@Controller
public class LoginController {
	
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST )
	public String Login(@RequestParam String Email,@RequestParam String Password,
			ModelMap model) {
		ValidateLogin val = new ValidateLogin();
		int res = val.ValidateLogin(Email, Password);
		if(res > 0) {
			Usuario user = UsuarioRepository.obterUsuario(res);
			model.put("selected", user);
			return "index";
		}

		return "login";
		
	}
}
