package br.infnet.edu.at_java.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.at_java.Classes.Filhas.Percurssao;
import br.infnet.edu.at_java.repositories.PercurssaoRepository;

@Service
public class PercussaoService {

	@Autowired
	private PercurssaoRepository _percussao;
	
	public Percurssao incluir(Percurssao percussao) {
		_percussao.incluir(percussao);
		return percussao;
	}

	public void excluir(Integer key) {
		_percussao.removerPercussao(key);
	}

	public Collection<Percurssao> obterLista(){
		return (Collection<Percurssao>) _percussao.obterLista();
	}
}
