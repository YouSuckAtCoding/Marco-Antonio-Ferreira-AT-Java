package br.infnet.edu.at_java.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.infnet.edu.at_java.Classes.Filhas.Percurssao;
import br.infnet.edu.at_java.repositories.PercurssaoRepository;

@SessionAttributes("percussao")
@Controller
public class PercurssaoController {
	@GetMapping("/listpercussao")
	public String Lista(ModelMap model) {
		model.put("percussao", PercurssaoRepository.obterLista());
		return "percurssao/listpercussao";
	}
	@GetMapping("/inserirPercussao")
	public String PaginaCadastro() {
		return "percurssao/cadastrar";
	}
	@PostMapping("/inserirPercussao")
	public String Create(Percurssao percussao) {
		PercurssaoRepository.incluir(percussao);
		return "redirect:/listpercussao";
	}
	@GetMapping(value = "/percussao/delete/{id}")
	public String Delete(@PathVariable int id) {
		PercurssaoRepository.removerPercussao(id);
		return "redirect:/listpercussao";
	}
}
