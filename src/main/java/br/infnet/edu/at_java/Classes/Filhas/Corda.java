package br.infnet.edu.at_java.Classes.Filhas;

import br.infnet.edu.at_java.Classes.Instrumento;
import br.infnet.edu.at_java.Exceptions.NullNumeroCordasException;

public class Corda extends Instrumento {

    private int NumCordas;

    public Corda(String nome, String tipo, double preco, int numcordas) throws Exception{
        super(nome, tipo, preco);
        
        var check = ValidateData(numcordas);
        if(check != null)
        {
            throw check;
        }   
        
        this.NumCordas = numcordas;   
        
    }

    @Override
    public double CalcularValorParcelado(int parcelas) {
        double valor = (this.getPreco() / parcelas);       
        return valor;
    }

    public int getNumCordas() {
        return NumCordas;
    }
   
    @Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append( " NumCordas: ");
		sb.append(NumCordas);
		return sb.toString();
	}

    private Exception ValidateData(int numcordas){
        if(numcordas <= 0){
            return new NullNumeroCordasException("O atributo Número de Cordas não pode ser vazio.");
        }
        return null;

    }
}
