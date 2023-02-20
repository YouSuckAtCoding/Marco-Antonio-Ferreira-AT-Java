package br.infnet.edu.at_java.Classes;

import lombok.Getter;
import lombok.Setter;


public class Usuario{
	
	private String Nome;
	private String Email;
	private String Password;
	
	public Usuario() {
		
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	public String getNome() {
		return Nome;
	}


	public String getEmail() {
		return Email;
	}


	public String getPassword() {
		return Password;
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