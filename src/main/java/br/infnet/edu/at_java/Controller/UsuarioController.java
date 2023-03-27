package br.infnet.edu.at_java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.repositories.DataLoaders.UsuarioLoader;
import br.infnet.edu.at_java.services.UsuarioService;
import org.springframework.ui.Model;

@Controller
public class UsuarioController{
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public String index(Model model) {
		if(usuarioService.obterLista().isEmpty()) {
			UsuarioLoader ul = new UsuarioLoader();
			usuarioService.incluir(ul.SetUsuarios());	
		}
		model.addAttribute("users", usuarioService.obterLista());
		return "usuario/list";
	}
	
	@GetMapping("/cadastrar")
	public String PaginaCadastro() {
		return "usuario/cadastrar";
	}
	
	@PostMapping("/inserir")
	public String Create(Usuario user) {
		System.out.println("Inclusão realizada com sucesso: " + user);
		usuarioService.incluir(user);
		return "login";
	}
	
	@DeleteMapping(value = "/user/delete/{id}")
	public String Delete(@PathVariable Long id) {
		usuarioService.excluir(id);
		return "";
	}
	
}