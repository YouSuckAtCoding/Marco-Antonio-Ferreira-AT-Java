package br.infnet.edu.at_java.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.infnet.edu.at_java.Classes.Filhas.Corda;
import br.infnet.edu.at_java.Classes.Filhas.Percurssao;
import br.infnet.edu.at_java.repositories.DataLoaders.CordaDataLoader;

@Repository
public class CordasRepository {
private static Integer id = 1;
	
	private static Collection<Corda> cordaMap = new ArrayList<Corda>();


	public static boolean incluir(Corda corda) {
		corda.setId(id++);
		
		try {
			cordaMap.add(corda);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public static Collection<Corda> obterLista(){
		CordaDataLoader cdl = new CordaDataLoader();
		for(Corda corda : cdl.ReadFile()) {
			cordaMap.add(corda);
		}
		return cordaMap;
	}
	public static Corda obterCorda(int id){
		for(Corda cord : cordaMap) {
			if(cord.getId() == id)
				return cord;
		}
		
		return new Corda();
	}
	public static String removerCorda(int id){
		for(Corda cord : cordaMap) {
			if(cord.getId() == id)
				cordaMap.remove(cord);
		}
		return "Removido";
	}
}
