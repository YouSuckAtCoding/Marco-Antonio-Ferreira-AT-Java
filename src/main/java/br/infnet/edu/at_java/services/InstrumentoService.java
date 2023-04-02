package br.infnet.edu.at_java.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.at_java.Classes.Instrumento;
import br.infnet.edu.at_java.repositories.InstrumentoRepository;

@Service
public class InstrumentoService {
	
		@Autowired
		private InstrumentoRepository _instrumento;
		
		public Instrumento incluir(Instrumento instrumento) {
			_instrumento.save(instrumento);
			return instrumento;
		}

		public void excluir(Long key) {
			_instrumento.deleteById(key);
		}

		public List<Instrumento> obterLista(){
			
			List<Instrumento> instrumentos =_instrumento.findAll();
			return instrumentos;
		}
	}

