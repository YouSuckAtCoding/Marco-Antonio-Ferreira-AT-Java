package br.infnet.edu.at_java.Classes;


import br.infnet.edu.at_java.Exceptions.InvalidNameException;
import br.infnet.edu.at_java.Exceptions.InvalidTipoException;
import br.infnet.edu.at_java.Exceptions.NullPrecoException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "Instrumento")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instrumento {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
	
	private String Nome;
    
    private String Tipo;

    private double Preco;
    


    public abstract double CalcularValorParcelado(int parcelas);

    public void setId(int id) {
		Id = id;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public void setPreco(double preco) {
		Preco = preco;
	}
	
    public int getId() {
		return Id;
	}
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