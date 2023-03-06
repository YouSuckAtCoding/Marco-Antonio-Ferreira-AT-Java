package br.infnet.edu.at_java.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.infnet.edu.at_java.Classes.Filhas.Sopro;
import br.infnet.edu.at_java.repositories.SoproRepository;

@SessionAttributes("sopro")
@Controller
public class SoproController{
	
	@GetMapping("/listsopro")
	public String Lista() {
		return "sopro/listsopro";
	}
	@GetMapping("/inserirSopro")
	public String PaginaCadastro() {
		return "sopro/cadastrar";
	}
	@PostMapping("/inserirSopro")
	public String Create(Sopro sopro, ModelMap model) {
		SoproRepository.incluir(sopro);
		model.put("sopro", SoproRepository.obterLista());
		return "sopro/listsopro";
	}
	@GetMapping(value = "/sopro/delete/{id}")
	public String Delete(@PathVariable int id) {
		SoproRepository.removerSopro(id);
		return "redirect:/listsopro";
	}
	
}