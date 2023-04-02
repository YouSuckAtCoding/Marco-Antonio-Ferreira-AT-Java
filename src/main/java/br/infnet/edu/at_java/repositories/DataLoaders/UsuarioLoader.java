package br.infnet.edu.at_java.repositories.DataLoaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.services.UsuarioService;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {
	
	@Autowired
	private UsuarioService _service;
	
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			Usuario user = new Usuario();
			user.setNome("Admin");
			user.setEmail("admin@gmail.com");
			user.setPassword("123");
			_service.incluir(user);
		}
		catch(Exception ex) {
			throw ex;
		}
		
		
	}
	
	
}
