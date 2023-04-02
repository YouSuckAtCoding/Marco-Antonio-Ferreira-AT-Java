package br.infnet.edu.at_java.repositories.DataLoaders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.infnet.edu.at_java.Classes.Filhas.Sopro;
import br.infnet.edu.at_java.Utility.UtilityClass;
import br.infnet.edu.at_java.services.SoproService;
@Order(3)
@Component
public class SoproLoader implements ApplicationRunner {
		
	@Autowired
	private SoproService _sopro;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try {
			Sopro sop = new Sopro();
			sop.setNome("Flauta " + UtilityClass.getAlphaNumericString(3));
			sop.setPreco(450);
			sop.setTipo("Doce");
			sop.setMaterial("Madeira");
			sop.setClassificacao("Madeira");
			_sopro.incluir(sop);
		}
		catch(Exception ex) {
			throw ex;
		}
		
		
	}
}
