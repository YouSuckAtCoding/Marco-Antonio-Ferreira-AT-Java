package br.infnet.edu.at_java.services;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.at_java.Classes.Filhas.Sopro;
import br.infnet.edu.at_java.repositories.SoproRepository;


@Service
public class SoproService {

	
	@Autowired
	private SoproRepository _sopro;
	
	public Sopro incluir(Sopro sopro) {
		_sopro.incluir(sopro);
		return sopro;
	}

	public void excluir(Integer key) {
		_sopro.removerSopro(key);
	}

	public Collection<Sopro> obterLista(){
		return (Collection<Sopro>) _sopro.obterLista();
	}
}
