package br.infnet.edu.at_java.repositories.DataLoaders;


import br.infnet.edu.at_java.Classes.Filhas.Corda;
import br.infnet.edu.at_java.Utility.UtilityClass;

public class CordaLoader {
	
	public Corda SetCordas() {
		
			Corda cord = new Corda();
			cord.setNome("Guitarra " + UtilityClass.getAlphaNumericString(3));
			cord.setPreco(500);
			cord.setTipo("Elétrica");
			cord.setNumCordas(6);
			return cord;
		
	}
}
