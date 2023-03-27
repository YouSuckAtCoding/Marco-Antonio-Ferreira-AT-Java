package br.infnet.edu.at_java.repositories.DataLoaders;

import org.springframework.beans.factory.annotation.Autowired;

import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.services.UsuarioService;

public class UsuarioLoader {
	
	public Usuario SetUsuarios() {
		Usuario user = new Usuario();
		user.setNome("Kappa");
		user.setEmail("kappa@gmail.com");
		user.setPassword("123");
		return user;
	}
	
	
}
