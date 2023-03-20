package br.infnet.edu.at_java.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.at_java.Classes.Filhas.Percussao;
import br.infnet.edu.at_java.repositories.PercussaoRepository;

@Service
public class PercussaoService {

	@Autowired
	private PercussaoRepository _percussao;
	
	public Percussao incluir(Percussao percussao) {
		_percussao.save(percussao);
		return percussao;
	}

	public void excluir(Long key) {
		_percussao.deleteById(key);
	}

	public List<Percussao> obterLista(){
		return _percussao.findAll();
	}
}
