package br.infnet.edu.at_java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.infnet.edu.at_java.Classes.Compra;
import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.services.CompraService;

@Controller
public class CompraController {

	@Autowired
	private CompraService _compra;
	
	@GetMapping("/listcompras")
	public String Lista(ModelMap model) {
		model.put("compras", _compra.obterLista());
		return "compra/listcompras";
	}
	@GetMapping("/inserirCompra")
	public String PaginaCadastro() {
		return "compra/cadastrar";
	}
	@PostMapping("/inserirCompra")
	public String Create(Compra compra, @SessionAttribute("selected") Usuario usuario) {
		compra.setUsuario(usuario);
		_compra.incluir(compra);
		return "redirect:/listcompras";
	}
	@GetMapping(value = "/compra/delete/{id}")
	public String Delete(@PathVariable Long id) {
		_compra.excluir(id);
		return "redirect:/listcompras";
	}
}
