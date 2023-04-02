package br.infnet.edu.at_java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.context.request.WebRequest;

import br.infnet.edu.at_java.Classes.Endereco;
import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.repositories.DataLoaders.UsuarioLoader;
import br.infnet.edu.at_java.services.UsuarioService;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
public class UsuarioController{
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public String index(Model model) {
	
		model.addAttribute("users", usuarioService.obterLista());
		return "usuario/list";
	}
	
	@GetMapping("/cadastrar")
	public String PaginaCadastro() {
		return "usuario/cadastrar";
	}
	
	@PostMapping("/inserir")
	public String Create(Usuario user, @SessionAttribute("endereco") Endereco endereco,
			DefaultSessionAttributeStore status, WebRequest request, ModelMap model) {
		user.setEndereco(endereco);
		System.out.println("Inclusão realizada com sucesso: " + user);
		model.remove("endereco");
	    status.cleanupAttribute(request, "endereco");
		usuarioService.incluir(user);
		return "login";
	}
	
	@GetMapping(value = "/user/delete/{id}")
	public String Delete(@PathVariable Long id, Model model) {
		try {
			if(id != 1) {
				usuarioService.excluir(id);
				return "redirect:/";
			}
			model.addAttribute("errodeleteuser", "Erro");
			return "index";
		}
		catch(Exception ex) {
			model.addAttribute("errodeleteuser", "Erro");
			return "index";
		}
		
		
	}
	
}