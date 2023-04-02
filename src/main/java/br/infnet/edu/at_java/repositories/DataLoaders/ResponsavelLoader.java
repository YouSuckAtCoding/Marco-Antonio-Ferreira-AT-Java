package br.infnet.edu.at_java.repositories.DataLoaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.infnet.edu.at_java.Classes.Responsavel;
import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.Utility.UtilityClass;
import br.infnet.edu.at_java.services.ResponsavelService;

@Order(2)
@Component
public class ResponsavelLoader implements ApplicationRunner {
	
	@Autowired
	private ResponsavelService _responsavel;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			Responsavel resp = new Responsavel();
			resp.setNome("Responsavel" + UtilityClass.getAlphaNumericString(3));
			resp.setCpf(UtilityClass.getAlphaNumericString(11));
			resp.setEmail(UtilityClass.getAlphaNumericString(5) + "@gmail.com");
			Usuario user = new Usuario();
			user.setId(1);
			resp.setUsuario(user);
			_responsavel.incluir(resp);
		}
		catch(Exception ex) {
			throw ex;
		}
		
		
	}
	
}
