package br.infnet.edu.at_java.services;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.at_java.Classes.Filhas.Corda;
import br.infnet.edu.at_java.repositories.CordasRepository;

@Service
public class CordaService {
	@Autowired
	private CordasRepository _corda;
	
	public Corda incluir(Corda corda) {
		_corda.incluir(corda);
		return corda;
	}

	public void excluir(Integer key) {
		_corda.removerCorda(key);
	}

	public Collection<Corda> obterLista(){
		return (Collection<Corda>) _corda.obterLista();
	}
}
