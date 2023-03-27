package br.infnet.edu.at_java.Classes;

import br.infnet.edu.at_java.Exceptions.InvalidCpfException;
import br.infnet.edu.at_java.Exceptions.InvalidEmailException;
import br.infnet.edu.at_java.Exceptions.InvalidNameException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
@Table(name = "Responsavel")
@NamedStoredProcedureQuery(name = "GetResponsavelByUsuarioId",
procedureName = "GetResponsavelByUsuarioId",
parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "UsuarioIdParam",type=int.class)},
resultClasses = Responsavel.class )
public class Responsavel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
    private String Nome;

    private String Cpf;

    private String Email;
    @ManyToOne
    @JoinColumn(name = "UsuarioId")
    private Usuario usuario;
   
    public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getNome() {
        return Nome;
    }

    public String getCpf() {
        return Cpf;
    }
   
    public String getEmail() {
        return Email;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Nome: ");
        str.append(Nome);
        str.append(" Cpf: ");
        str.append(Cpf);
        str.append(" Email: ");
        str.append(Email);

        return str.toString();
    }

    private Exception ValidateData(String nome, String cpf, String email){
        if(nome.length() <= 0 || nome == null){
            return new InvalidNameException("O atributo Nome do Responsável não pode ser vazio.");
        }
        if(cpf.length() <= 0 || cpf == null){
            return new InvalidCpfException("O atributo CPF do Responsável nao pode ser vazio.");
        }
        
        if(email.length() <= 0 || email == null){
            return new InvalidEmailException("O atributo Email do Responsável não pode ser vazio.");
        }
        return null;

    }
}
