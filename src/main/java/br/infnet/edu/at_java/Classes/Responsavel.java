package br.infnet.edu.at_java.Classes;

import br.infnet.edu.at_java.Exceptions.InvalidCpfException;
import br.infnet.edu.at_java.Exceptions.InvalidEmailException;
import br.infnet.edu.at_java.Exceptions.InvalidNameException;

public class Responsavel {
    
    private String Nome;

    private String Cpf;

    private String Email;

    public Responsavel(String nome, String cpf, String email) throws Exception{
        
        var check = ValidateData(nome, cpf, email);
        if(check != null)
        {
            throw check;
        }
           
        this.Nome = nome;
        this.Cpf = cpf;
        this.Email = email;

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
