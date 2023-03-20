package br.infnet.edu.at_java.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.at_java.Classes.Filhas.Corda;
import br.infnet.edu.at_java.repositories.CordasRepository;

@Service
public class CordaService {
	@Autowired
	private CordasRepository _corda;
	
	public Corda incluir(Corda corda) {
		_corda.save(corda);
		return corda;
	}

	public void excluir(Long key) {
		_corda.deleteById(key);
	}

	public List<Corda> obterLista(){
		return _corda.findAll();
	}
}
