package br.infnet.edu.at_java.Classes;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
@NamedStoredProcedureQuery(name = "Login",
procedureName = "Login",parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "EmailParam",type=String.class), 
@StoredProcedureParameter(mode = ParameterMode.IN,name = "PasswordParam",type=String.class)}, 
resultClasses = Usuario.class )
@NamedStoredProcedureQuery(name = "DeleteUserAndRelated",
procedureName = "DeleteUserAndRelated",
parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "UserId",type=int.class)})
public class Usuario implements Comparable<Usuario>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Nome;
	private String Email;
	private String Password;
	
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "EnderecoId")
	private Endereco Endereco;
	

	public Endereco getEndereco() {
		return Endereco;
	}

	public void setEndereco(Endereco endereco) {
		Endereco = endereco;
	}

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
	
	
	@Override
	public int compareTo(Usuario user) {
		return this.getNome().compareTo(user.getNome());
	}

	
}