package br.infnet.edu.at_java.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.at_java.Classes.Compra;
import br.infnet.edu.at_java.repositories.CompraRepository;


@Service
public class CompraService {
	
	@Autowired
	private CompraRepository _compra;
	
	public Compra incluir(Compra compra) {
		_compra.save(compra);
		return compra;
	}

	public void excluir(Long key) {
		_compra.deleteById(key);
	}

	public List<Compra> obterLista(){
		List<Compra> compras =_compra.findAll();
		Collections.sort(compras);
		return compras;
	}
}
