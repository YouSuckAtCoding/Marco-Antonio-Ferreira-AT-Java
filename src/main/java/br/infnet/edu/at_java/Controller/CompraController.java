package br.infnet.edu.at_java.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import br.infnet.edu.at_java.Classes.Compra;
import br.infnet.edu.at_java.Classes.Instrumento;
import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.services.CompraService;

@Controller
public class CompraController {

	@Autowired
	private CompraService _compra;
	
	@GetMapping("/listcompras")
	public String Lista(ModelMap model) {
		List<Compra> check = _compra.obterLista();
		model.put("compras", _compra.obterLista());
		return "compra/listcompras";
	}
	@GetMapping("/inserirCompra")
	public ModelAndView PaginaCadastro() {
		return new ModelAndView("redirect:/listinstrumentos");
		
	}
	@PostMapping("/inserirCompra")
	public String Create(Compra compra, @SessionAttribute("selected") Usuario usuario) {
		compra.setUsuario(usuario);
		compra.setDataCompra(LocalDate.now());
		compra.setTotal(GetTotal(compra.getProdutos()));
		_compra.incluir(compra);
		return "redirect:/listcompras";
	}
	@GetMapping(value = "/compra/delete/{id}")
	public String Delete(@PathVariable Long id) {
		_compra.excluir(id);
		return "redirect:/listcompras";
	}
	
	private double GetTotal(List<Instrumento> list) {
		double Total = 0;
		for(Instrumento inst : list) {
			Total = Total + inst.getPreco();
		}
		return Total;
	}
}
