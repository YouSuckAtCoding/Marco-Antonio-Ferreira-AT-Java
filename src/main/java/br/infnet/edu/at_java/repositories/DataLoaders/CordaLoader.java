package br.infnet.edu.at_java.repositories.DataLoaders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.infnet.edu.at_java.Classes.Filhas.Corda;
import br.infnet.edu.at_java.Utility.UtilityClass;
import br.infnet.edu.at_java.services.CordaService;
@Order(5)
@Component
public class CordaLoader implements ApplicationRunner{
	
	@Autowired
	private CordaService _corda;
	
		@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			Corda cord = new Corda();
			cord.setNome("Guitarra " + UtilityClass.getAlphaNumericString(3));
			cord.setPreco(500);
			cord.setTipo("Elétrica");
			cord.setNumCordas(6);
			_corda.incluir(cord);
		}
		catch(Exception ex) {
			throw ex;
		}
		
		
	}
}
