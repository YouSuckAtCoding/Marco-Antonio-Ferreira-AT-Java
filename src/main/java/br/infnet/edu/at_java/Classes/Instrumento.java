package br.infnet.edu.at_java.Classes;

import br.infnet.edu.at_java.Exceptions.InvalidNameException;
import br.infnet.edu.at_java.Exceptions.InvalidTipoException;
import br.infnet.edu.at_java.Exceptions.NullPrecoException;

public abstract class Instrumento {
    
    private String Nome;
    
    private String Tipo;

    private double Preco;

    public Instrumento(String nome, String Tipo, double preco) throws Exception {
                   
        var check = ValidateData(nome, Tipo, preco);
        if(check != null){
            throw check;
        }
        
        this.Nome = nome;
        this.Preco = preco;
        this.Tipo = Tipo;
        
        
    }

    public abstract double CalcularValorParcelado(int parcelas);

    public String getNome() {
        return Nome;
    }

    public String getTipo() {
        return Tipo;
    }
   
    public double getPreco() {
        return Preco;
    }

    @Override
    public String toString(){
        
        StringBuilder str = new StringBuilder();
        str.append("Nome: ");
        str.append(Nome);
        str.append(" Tipo: ");
        str.append(Tipo);
        str.append(" Preco R$:");
        str.append(Preco);

        return str.toString();
    }

    private Exception ValidateData(String nome, String Tipo, double preco)
    {
        
        if(nome.length() <= 0 || nome == null){
            return new InvalidNameException("O atributo Nome não pode ser vazio.");
        }
        if(Tipo.length() <= 0 || Tipo == null){
            return new InvalidTipoException("O atributo Tipo não pode ser vazio.");
        }
        if(preco <= 0){
            return new NullPrecoException("O atributo Preço não pode ser 0 ou menor que 0.");
        }
        return null;

    }
   


}