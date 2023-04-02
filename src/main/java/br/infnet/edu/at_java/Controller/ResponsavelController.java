package br.infnet.edu.at_java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.infnet.edu.at_java.Classes.Responsavel;
import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.services.ResponsavelService;

@SessionAttributes("responsaveis")
@Controller
public class ResponsavelController {

	@Autowired
	private ResponsavelService _responsavel;
	
	@GetMapping("/listresponsavel")
	public String Lista(ModelMap model, @SessionAttribute("selected") Usuario usuario) {
		model.put("responsaveis", _responsavel.obterLista(usuario.getId()));
		return "responsavel/listresponsavel";
	}
	@GetMapping("/inserirResponsavel")
	public String PaginaCadastro() {
		return "responsavel/cadastrar";
	}
	@PostMapping("/inserirResponsavel")
	public String Create(Responsavel responsavel, @SessionAttribute("selected") Usuario usuario) {
		if(usuario == null) {
			return "login";
		}
		responsavel.setUsuario(usuario);
		_responsavel.incluir(responsavel);
		return "redirect:/listresponsavel";
	}
	@GetMapping(value = "/responsavel/delete/{id}")
	public String Delete(@PathVariable Long id, Model model) {
		try {
			_responsavel.excluir(id);	
		}
		catch(Exception ex) {
			model.addAttribute("errodelete", "Erro");
			return "responsavel/listresponsavel";	
		}
		
		return "redirect:/listresponsavel";
	}
}
