package br.infnet.edu.at_java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.at_java.Classes.Responsavel;
import br.infnet.edu.at_java.repositories.ResponsavelRepository;

@Service
public class ResponsavelService {

	@Autowired
	private ResponsavelRepository _responsavel;
	
	public Responsavel incluir(Responsavel responsavel) {
		_responsavel.save(responsavel);
		return responsavel;
		
	}
	
	public void excluir(long id) {
		_responsavel.deleteById(id);
		
	}
	
	public List<Responsavel> obterLista(long usuarioId){
		return _responsavel.GetByUsuario(usuarioId);
		
	}
}
