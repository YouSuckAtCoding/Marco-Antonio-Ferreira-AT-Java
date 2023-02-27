package br.infnet.edu.at_java.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.repositories.UsuarioRepository;

public class ValidateLogin {
	
	private static Map<Integer, Usuario> lista = new HashMap<Integer, Usuario>();
	
	public int ValidateLogin(String email, String password) {
		
		lista = UsuarioRepository.obterLista();
		for(Usuario user : lista.values()) {
			String emailCheck = user.getEmail();
			String passwordCheck = user.getPassword();
			if(emailCheck.equals(email)  &&  passwordCheck.equals(password))
				return user.getId();
		}
		return -1;
	}
}
