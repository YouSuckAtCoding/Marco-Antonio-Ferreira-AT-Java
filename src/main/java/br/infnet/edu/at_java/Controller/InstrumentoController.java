package br.infnet.edu.at_java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.infnet.edu.at_java.Classes.Instrumento;
import br.infnet.edu.at_java.services.InstrumentoService;

@SessionAttributes("produtos")
@Controller
public class InstrumentoController {

	@Autowired
	private InstrumentoService _instrumento;
	
	@GetMapping("/listinstrumentos")
	public String Lista(ModelMap model) {
		model.put("produtos", _instrumento.obterLista());
		return "compra/cadastrar";
	}
	@GetMapping("/listinstrumentosgerais")
	public String ListaInstrumentos(ModelMap model) {
		model.put("produtos", _instrumento.obterLista());
		return "instrumento/listinstrumento";
	}
	@GetMapping("/inserirProduto")
	public String Create() {
		return "instrumento/cadastrar";
		
	}
	@PostMapping("/inserirProduto")
	public String Create(Instrumento instrumento, ModelMap model) {
		_instrumento.incluir(instrumento);
		return "redirect:/listinstrumentosgerais";
		
	}
	@GetMapping(value = "/instrumento/delete/{id}")
	public String Delete(@PathVariable Long id, Model model)
	{
		try {
			_instrumento.excluir(id);
			return "redirect:/listinstrumentosgerais";	
		}
		catch(Exception ex){
			model.addAttribute("errodeleteinstrumento", "Erro");
			return "/instrumento/listinstrumento";	
		}
		
	}
}
	
