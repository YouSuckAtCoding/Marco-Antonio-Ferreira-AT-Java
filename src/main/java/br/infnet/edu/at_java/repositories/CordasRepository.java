package br.infnet.edu.at_java.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.infnet.edu.at_java.Classes.Filhas.Corda;
import br.infnet.edu.at_java.Classes.Filhas.Percurssao;

public class CordasRepository {
private static Integer id = 1;
	
	private static Map<Integer, Corda> cordaMap = new HashMap<Integer, Corda>();


	public static boolean incluir(Corda corda) {
		corda.setId(id++);
		
		try {
			cordaMap.put(corda.getId(), corda);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public static Collection<Corda> obterLista(){
		return cordaMap.values();
	}
	public static Corda obterCorda(int id){
		return cordaMap.get(id);
	}
	public static String removerCorda(int id){
		cordaMap.remove(id);
		return "Removido";
	}
}
