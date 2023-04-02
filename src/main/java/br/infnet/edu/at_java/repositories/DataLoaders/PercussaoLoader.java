package br.infnet.edu.at_java.repositories.DataLoaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.infnet.edu.at_java.Classes.Filhas.Percussao;
import br.infnet.edu.at_java.Utility.UtilityClass;
import br.infnet.edu.at_java.services.PercussaoService;

@Order(4)
@Component
public class PercussaoLoader implements ApplicationRunner {
	
	@Autowired
	private PercussaoService _percussao;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Percussao perc =  new Percussao();
		perc.setNome("Bateria " + UtilityClass.getAlphaNumericString(3));
		perc.setPreco(3000);
		perc.setTipo("Percussão");
		perc.setCapacidadeAfinacao(true);
		_percussao.incluir(perc);
		
	}
}
