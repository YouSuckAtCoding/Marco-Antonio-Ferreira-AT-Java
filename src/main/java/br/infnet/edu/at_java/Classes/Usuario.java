package br.infnet.edu.at_java.Classes;

import lombok.Getter;
import lombok.Setter;


public class Usuario{
	
	private int Id;
	private String Nome;
	private String Email;
	private String Password;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	public Usuario() {
		
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
	public void setNome(String nome) {
		Nome = nome;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setPassword(String password) {
		Password = password;
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