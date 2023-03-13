package br.infnet.edu.at_java.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.infnet.edu.at_java.Classes.Filhas.Percurssao;
import br.infnet.edu.at_java.repositories.DataLoaders.PercussaoDataLoader;

@Repository
public class PercurssaoRepository {
private static Integer id = 1;
	
	private static Collection<Percurssao> percurssaoMap = new ArrayList<Percurssao>();


	public  boolean incluir(Percurssao percurssao) {
		percurssao.setId(id++);
		
		try {
			percurssaoMap.add(percurssao);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public  Collection<Percurssao> obterLista(){
		PercussaoDataLoader pdl = new PercussaoDataLoader();
		for(Percurssao perc : pdl.ReadFile()) {
			percurssaoMap.add(perc);
		}
			
		
		return percurssaoMap;
	}
	public  Percurssao obterSopro(int id){
		for(Percurssao perc : percurssaoMap) {
			if(perc.getId() == id) {
				return perc;
			}
		}
		
		return new Percurssao();
	}
	public  String removerPercussao(int id){
		for(Percurssao perc : percurssaoMap) {
			if(perc.getId() == id) {
				percurssaoMap.remove(perc);
			}
		}
		
	 	return "Removido";
	}
}
