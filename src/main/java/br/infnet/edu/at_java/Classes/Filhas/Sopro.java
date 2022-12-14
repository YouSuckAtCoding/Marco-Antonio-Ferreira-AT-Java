package br.infnet.edu.at_java.Classes.Filhas;

import br.infnet.edu.at_java.Classes.Instrumento;
import br.infnet.edu.at_java.Exceptions.InvalidClassificationException;
import br.infnet.edu.at_java.Exceptions.InvalidMaterialException;

public class Sopro extends Instrumento{

    private String Material;

    private String Classificacao;

    public Sopro(String nome, String tipo, double preco, String material, String classificacao) throws Exception  {
        super(nome, tipo, preco);
         
            var check = ValidateData(material, classificacao);
            if(check != null)
            {
                throw check;
            }   
            
            this.Material = material;
            this.Classificacao = classificacao;
        
    }

    @Override
    public double CalcularValorParcelado(int parcelas) {
        double valor = ((this.getPreco() * 1.05) / parcelas);       
        return valor;
    }

    public String getMaterial() {
        return Material;
    }

    public String getClassificacao() {
        return Classificacao;
    }
    
    @Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" Material: ");
		sb.append(Material);
		sb.append(" Classificação: ");
		sb.append(Classificacao);
	
		return sb.toString();
	}

    private Exception ValidateData(String material, String classificacao){
        
        if(material.length() <= 0 || material == null){
            return new InvalidMaterialException("O atributo Material não pode ser vazio.");
        }
        if(classificacao.length() <= 0 || classificacao == null){
            return new InvalidClassificationException("O atributo Classiicação não pode ser vazio.");
        }
        return null;

    }
	
}
