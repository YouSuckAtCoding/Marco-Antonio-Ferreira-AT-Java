package br.infnet.edu.at_java.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.Utility.ValidateLogin;
import br.infnet.edu.at_java.repositories.UsuarioRepository;

@Controller
public class UsuarioController{
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/cadastrar")
	public String PaginaCadastro() {
		return "usuario/cadastrar";
	}
	
	@PostMapping("/inserir")
	public String Create(Usuario user) {
		System.out.println("Inclusão realizada com sucesso: " + user);
		UsuarioRepository.incluir(user);
		return "login";
	}
	
	
}