package br.infnet.edu.at_java.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.infnet.edu.at_java.Classes.Filhas.Sopro;


public class SoproRepository {

	private static Integer id = 1;
	
	private static Map<Integer, Sopro> soproMap = new HashMap<Integer, Sopro>();


	public static boolean incluir(Sopro sopro) {
		sopro.setId(id++);
		
		try {
			soproMap.put(sopro.getId(), sopro);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public static Collection<Sopro> obterLista(){
		return soproMap.values();
	}
	public static Sopro obterSopro(int id){
		return soproMap.get(id);
	}
	public static String removerSopro(int id){
		soproMap.remove(id);
		return "Removido";
	}
}
