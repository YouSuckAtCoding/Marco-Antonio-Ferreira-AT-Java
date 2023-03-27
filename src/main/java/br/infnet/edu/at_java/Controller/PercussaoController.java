package br.infnet.edu.at_java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.infnet.edu.at_java.Classes.Filhas.Percussao;
import br.infnet.edu.at_java.repositories.PercussaoRepository;
import br.infnet.edu.at_java.repositories.DataLoaders.PercussaoLoader;
import br.infnet.edu.at_java.services.PercussaoService;

@SessionAttributes("percussao")
@Controller
public class PercussaoController {
	
	@Autowired
	private PercussaoService percussaoService;
	
	@GetMapping("/listpercussao")
	public String Lista(ModelMap model) {
		if(percussaoService.obterLista().isEmpty()) {
			PercussaoLoader pl = new PercussaoLoader();
			percussaoService.incluir(pl.SetPoercussao());	
		}
		
		model.put("percussao", percussaoService.obterLista());
		return "percurssao/listpercussao";
	}
	@GetMapping("/inserirPercussao")
	public String PaginaCadastro() {
		return "percurssao/cadastrar";
	}
	@PostMapping("/inserirPercussao")
	public String Create(Percussao percussao) {
		percussaoService.incluir(percussao);
		return "redirect:/listpercussao";
	}
	@GetMapping(value = "/percussao/delete/{id}")
	public String Delete(@PathVariable Long id) {
		percussaoService.excluir(id);
		return "redirect:/listpercussao";
	}
}
