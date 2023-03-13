package br.infnet.edu.at_java.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.Utility.ValidateLogin;
import br.infnet.edu.at_java.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository _usuario;
	
	public Usuario autenticar(Usuario usuario) {
		ValidateLogin val = new ValidateLogin();
		int res = val.ValidateLogin(usuario.getEmail(), usuario.getPassword());
		if(res > 0) {
			Usuario user = UsuarioRepository.obterUsuario(res);
			return user;
		}
		return new Usuario();
		
		
	}

	public Usuario incluir(Usuario usuario) {
		_usuario.incluir(usuario);
		return usuario;
	}

	public void excluir(Integer key) {
		_usuario.removerUsuario(key);
	}

	public Collection<Usuario> obterLista(){
		return (Collection<Usuario>) _usuario.obterLista();
	}
}
