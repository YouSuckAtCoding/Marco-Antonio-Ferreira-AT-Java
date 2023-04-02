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
	public String Delete(@PathVariable Long id, Model model) {
		try {
			_sopro.excluir(id);	
		}
		catch(Exception ex) {
			model.addAttribute("errodeletesopro", "Erro");
			return "sopro/listsopro";
		}
		
		return "redirect:/listsopro";
	}
	
}