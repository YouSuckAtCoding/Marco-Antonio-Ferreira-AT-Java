package br.infnet.edu.at_java.services;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.at_java.Classes.Filhas.Sopro;
import br.infnet.edu.at_java.repositories.SoproRepository;


@Service
public class SoproService {

	
	@Autowired
	private SoproRepository _sopro;
	
	public Sopro incluir(Sopro sopro) {
		_sopro.save(sopro);
		return sopro;
	}

	public void excluir(Long key) {
		_sopro.deleteById(key);
	}

	public List<Sopro> obterLista(){
		List<Sopro> sopros =_sopro.findAll();
		Collections.sort(sopros);
		return sopros;
	}
}
