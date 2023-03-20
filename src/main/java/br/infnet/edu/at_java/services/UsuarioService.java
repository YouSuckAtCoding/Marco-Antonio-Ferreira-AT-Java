package br.infnet.edu.at_java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository _usuario;
	
	public Usuario autenticar(Usuario usuario) {
		
		return new Usuario();
		
		
	}

	public Usuario incluir(Usuario usuario) {
		_usuario.save(usuario);
		return usuario;
	}

	public void excluir(Long key) {
		_usuario.deleteById(key);;
	}

	public List<Usuario> obterLista(){
		return _usuario.findAll();
	}
	
	public Usuario login(String Email, String Password) {
		Usuario logged =_usuario.Login(Email, Password);
		return logged;
		
	}
}
