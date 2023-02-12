package br.infnet.edu.at_java.Classes;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Usuario{
	
	public String Nome;
	public String Email;
	public String Password;
	
	public Usuario(String name, String email, String password ) {
		this.setNome(name);
		this.setEmail(email);
		this.setPassword(password);
	}
	
	@Override
	public String toString() {

		return String.format(
				"O usuario %s tem as credenciais %s e %s", 
				Nome,
				Email,
				Password
				
			);
	}
}