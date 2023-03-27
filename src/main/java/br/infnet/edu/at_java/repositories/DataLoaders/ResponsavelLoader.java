package br.infnet.edu.at_java.repositories.DataLoaders;

import org.springframework.beans.factory.annotation.Autowired;

import br.infnet.edu.at_java.Classes.Responsavel;
import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.Utility.UtilityClass;
import br.infnet.edu.at_java.services.ResponsavelService;

public class ResponsavelLoader {
	
	public Responsavel SetResponsaveis(Usuario user) {
		
			Responsavel resp = new Responsavel();
			resp.setNome("Responsavel" + UtilityClass.getAlphaNumericString(3));
			resp.setCpf(UtilityClass.getAlphaNumericString(11));
			resp.setEmail(UtilityClass.getAlphaNumericString(5) + "@gmail.com");
			resp.setUsuario(user);
			return resp;
		
		
		
	}
	
}
