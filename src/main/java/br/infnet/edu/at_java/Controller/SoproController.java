package br.infnet.edu.at_java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.infnet.edu.at_java.Classes.Filhas.Sopro;
import br.infnet.edu.at_java.repositories.SoproRepository;
import br.infnet.edu.at_java.repositories.DataLoaders.SoproLoader;
import br.infnet.edu.at_java.services.SoproService;


@SessionAttributes("sopro")
@Controller
public class SoproController{
	
	@Autowired
	private SoproService _sopro;
	
	@GetMapping("/listsopro")
	public String Lista(Model model) {
		if(_sopro.obterLista().isEmpty()) {
			SoproLoader sl = new SoproLoader();
			_sopro.incluir(sl.SetSopro());	
		}
		model.addAttribute("sopro" , _sopro.obterLista());
		return "sopro/listsopro";
	}
	@GetMapping("/inserirSopro")
	public String PaginaCadastro() {
		return "sopro/cadastrar";
	}
	@PostMapping("/inserirSopro")
	public String Create(Sopro sopro, ModelMap model) {
		
		_sopro.incluir(sopro);
		return "redirect:/listsopro";
	}
	@GetMapping(value = "/sopro/delete/{id}")
	public String Delete(@PathVariable Long id) {
		_sopro.excluir(id);
		return "redirect:/listsopro";
	}
	
}