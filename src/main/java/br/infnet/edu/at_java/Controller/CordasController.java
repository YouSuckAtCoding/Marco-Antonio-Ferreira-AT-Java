package br.infnet.edu.at_java.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.infnet.edu.at_java.Classes.Filhas.Corda;

import br.infnet.edu.at_java.repositories.CordasRepository;

@SessionAttributes("cordas")
@Controller
public class CordasController {
	@GetMapping("/listcordas")
	public String Lista() {
		return "cordas/listcordas";
	}
	@GetMapping("/inserirCordas")
	public String PaginaCadastro() {
		return "cordas/cadastrar";
	}
	@PostMapping("/inserirCordas")
	public String Create(Corda corda, ModelMap model) {
		CordasRepository.incluir(corda);
		model.put("cordas", CordasRepository.obterLista());
		return "cordas/listcordas";
	}
	@GetMapping(value = "/corda/delete/{id}")
	public String Delete(@PathVariable int id) {
		CordasRepository.removerCorda(id);
		return "redirect:/listcordas";
	}
}
