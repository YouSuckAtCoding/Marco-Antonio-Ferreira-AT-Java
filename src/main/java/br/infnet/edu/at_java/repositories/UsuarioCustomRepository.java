package br.infnet.edu.at_java.repositories;

import br.infnet.edu.at_java.Classes.Usuario;

public interface UsuarioCustomRepository {
	
	Usuario Login(String Email, String Password); 
}
