package br.infnet.edu.at_java.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.infnet.edu.at_java.Classes.Filhas.Percurssao;

public class PercurssaoRepository {
private static Integer id = 1;
	
	private static Map<Integer, Percurssao> percurssaoMap = new HashMap<Integer, Percurssao>();


	public static boolean incluir(Percurssao percurssao) {
		percurssao.setId(id++);
		
		try {
			percurssaoMap.put(percurssao.getId(), percurssao);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public static Collection<Percurssao> obterLista(){
		return percurssaoMap.values();
	}
	public static Percurssao obterSopro(int id){
		return percurssaoMap.get(id);
	}
	public static String removerPercussao(int id){
		percurssaoMap.remove(id);
	 	return "Removido";
	}
}
