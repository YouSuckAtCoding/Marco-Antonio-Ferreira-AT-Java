package br.infnet.edu.at_java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.infnet.edu.at_java.Classes.Filhas.Corda;

import br.infnet.edu.at_java.repositories.CordasRepository;
import br.infnet.edu.at_java.repositories.DataLoaders.CordaLoader;
import br.infnet.edu.at_java.services.CordaService;

@SessionAttributes("cordas")
@Controller
public class CordasController {
	
	@Autowired
	private CordaService _corda;
	
	@GetMapping("/listcordas")
	public String Lista(ModelMap model) {
		if(_corda.obterLista().isEmpty()) {
			CordaLoader cl = new CordaLoader();
			_corda.incluir(cl.SetCordas());	
		}
		model.put("cordas", _corda.obterLista());
		return "cordas/listcordas";
	}
	@GetMapping("/inserirCordas")
	public String PaginaCadastro() {
		return "cordas/cadastrar";
	}
	@PostMapping("/inserirCordas")
	public String Create(Corda corda) {
		_corda.incluir(corda);
		return "redirect:/listcordas";
	}
	@GetMapping(value = "/corda/delete/{id}")
	public String Delete(@PathVariable Long id) {
		_corda.excluir(id);
		return "redirect:/listcordas";
	}
}
