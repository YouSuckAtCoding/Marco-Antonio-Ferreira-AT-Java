package br.infnet.edu.at_java.Controller;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.infnet.edu.at_java.Classes.Endereco;
import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.services.EnderecoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SessionAttributes("endereco")
@Controller
public class EnderecoController {

	
	@Autowired
	private EnderecoService _endereco;
	
	
	@PostMapping("/buscarcep")
	public String buscarcep(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {

		String cep = request.getParameter("cep");
		StringBuffer sb = new StringBuffer();
		sb.append("https://viacep.com.br/ws/").append(cep).append("/json/");
		Endereco Endereco = MakeRequest(sb);
		if (Endereco != null) {
			model.addAttribute("endereco", Endereco);
			
			return "/endereco/cadastrar";
		}
		model.addAttribute("erro", "Ocorreu um erro ao buscar o cep");
		return "/endereco/cadastrar"; 
	}
	
	@GetMapping("/inserirEndereco")
	public String Create() {
		return "/endereco/cadastrar";
		
	}
	@PostMapping("/inserirEndereco")
	public String Create(Endereco endereco, ModelMap model) {
		model.put("endereco", endereco);
		_endereco.incluir(endereco);
		return "/usuario/cadastrar";
		
	}
	
	
	
	@GetMapping(value = "/endereco/delete/{id}")
	public String Delete(@PathVariable Long id) {
		_endereco.excluir(id);
		return "/listendereco";
	}
	private Endereco MakeRequest(StringBuffer sb) {
		try {
			Endereco Endereco = new Endereco();
			URL url = new URL(sb.toString());

			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			connection.connect();

			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				throw new RuntimeException("Ocorreu um erro: " + responseCode);
			} else {

				ObjectMapper mapper = new ObjectMapper();
				Endereco = mapper.readValue(url, Endereco.class);

			}
			return Endereco;
		} catch (Exception ex) {
			return null;
		}
	}
}
