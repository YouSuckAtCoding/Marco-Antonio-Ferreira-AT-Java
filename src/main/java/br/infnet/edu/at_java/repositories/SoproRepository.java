package br.infnet.edu.at_java.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.infnet.edu.at_java.Classes.Filhas.Sopro;
import br.infnet.edu.at_java.repositories.DataLoaders.SoproDataLoader;

@Repository
public class SoproRepository {

	private static Integer id = 3;
	
	private static Collection<Sopro> soproMap = new ArrayList<Sopro>();


	public  boolean incluir(Sopro sopro) {
		sopro.setId(id++);
		
		try {
			soproMap.add(sopro);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public  Collection<Sopro> obterLista(){
		
		SoproDataLoader sdl = new SoproDataLoader();
		for(Sopro sopro : sdl.ReadFile()) {
			soproMap.add(sopro);
		}
		
		return soproMap;
	}
	public  Sopro obterSopro(int id){
		for(Sopro sopro : soproMap) {
			if(sopro.getId() == id)
				return sopro;
		}
		return new Sopro();
	}
	public  String removerSopro(int id){
		for(Sopro sopro : soproMap) {
			if(sopro.getId() == id)
				soproMap.remove(sopro);
		}
		
		
		return "Removido";
	}
}
