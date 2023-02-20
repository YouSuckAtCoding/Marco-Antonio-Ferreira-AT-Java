package br.infnet.edu.at_java.Utility;

import java.util.ArrayList;
import java.util.List;

import br.infnet.edu.at_java.Classes.Usuario;
import br.infnet.edu.at_java.repositories.UsuarioRepository;

public class ValidateLogin {
	
	private static List<Usuario> lista = new ArrayList<Usuario>();
	
	public boolean ValidateLogin(String email, String password) {
		
		lista = UsuarioRepository.obterLista();
		for(Usuario user : lista) {
			String emailCheck = user.getEmail();
			String passwordCheck = user.getPassword();
			if(emailCheck.equals(email)  &&  passwordCheck.equals(password))
				return true;
		}
		return false;
	}
}
