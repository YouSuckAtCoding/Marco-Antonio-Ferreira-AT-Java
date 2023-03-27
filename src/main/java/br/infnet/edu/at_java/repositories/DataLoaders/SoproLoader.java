package br.infnet.edu.at_java.repositories.DataLoaders;

import br.infnet.edu.at_java.Classes.Filhas.Sopro;
import br.infnet.edu.at_java.Utility.UtilityClass;

public class SoproLoader {
		
	public Sopro SetSopro() {
	
			Sopro sop = new Sopro();
			sop.setNome("Flauta " + UtilityClass.getAlphaNumericString(3));
			sop.setPreco(450);
			sop.setTipo("Doce");
			sop.setMaterial("Madeira");
			sop.setClassificacao("Madeira");
			return sop;
	
	}
}
