package br.infnet.edu.at_java.repositories.DataLoaders;

import br.infnet.edu.at_java.Classes.Filhas.Percussao;
import br.infnet.edu.at_java.Utility.UtilityClass;

public class PercussaoLoader {
	
	public Percussao SetPoercussao() {
		
			Percussao perc =  new Percussao();
			perc.setNome("Bateria " + UtilityClass.getAlphaNumericString(3));
			perc.setPreco(3000);
			perc.setTipo("Percussão");
			perc.setCapacidadeAfinacao(true);
			return perc;
		
		
	}
}
