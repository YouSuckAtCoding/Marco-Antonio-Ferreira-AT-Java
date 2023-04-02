package br.infnet.edu.at_java.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.at_java.Classes.Endereco;
import br.infnet.edu.at_java.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
		@Autowired
		private EnderecoRepository _endereco;
		
		public Endereco incluir(Endereco endereco) {
			_endereco.save(endereco);
			return endereco;
		}

		public void excluir(Long key) {
			_endereco.deleteById(key);
		}
		
		public Optional<Endereco> obterEndereco(Long id){
			return _endereco.findById(id);
		}
}

