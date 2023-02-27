package br.infnet.edu.at_java.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.infnet.edu.at_java.Classes.Usuario;

public class UsuarioRepository {
	
	private static Integer id = 1;
	
	private static Map<Integer, Usuario> userMap = new HashMap<Integer, Usuario>();


	public static boolean incluir(Usuario usuario) {
		usuario.setId(id++);
		
		try {
			userMap.put(usuario.getId(), usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public static Map<Integer, Usuario> obterLista(){
		return userMap;
	}
	public static Usuario obterUsuario(int id){
		return userMap.get(id);
	}
}
