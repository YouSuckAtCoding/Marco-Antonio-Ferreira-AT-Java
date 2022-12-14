package br.infnet.edu.at_java.Classes.Filhas;

import br.infnet.edu.at_java.Classes.Instrumento;
import br.infnet.edu.at_java.Exceptions.InvalidProducaoSomException;

public class Percurssao extends Instrumento {

    private boolean CapacidadeAfinacao; 

    private String ProducaoSom;    

    public Percurssao(String nome, String tipo, double preco, boolean capacidadeAfinacao, String producaoSom) throws Exception {
        super(nome, tipo, preco);
        
         var check = ValidateData(producaoSom);
         if(check != null)
         {
             throw check;
         }
            
         this.CapacidadeAfinacao = capacidadeAfinacao;
         this.ProducaoSom = producaoSom; 
    }
    @Override
    public double CalcularValorParcelado(int parcelas) {
        double valor = ((this.getPreco() * 1.1) / parcelas);       
        return valor;
    }
    
    public boolean isCapacidadeAfinacao() {
        return CapacidadeAfinacao;
    }

    public String getProducaoSom() {
        return ProducaoSom;
    }

    @Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" Capacidade Afinação: ");
		sb.append(CapacidadeAfinacao ? "Sim" : "Não");
		sb.append(" Producao de Som: ");
		sb.append(ProducaoSom);
		return sb.toString();
	}
	
    private Exception ValidateData(String producaoSom){
        if(producaoSom.length() <= 0 || producaoSom == null){
            return new InvalidProducaoSomException("O atributo Produção de Som não pode ser vazio.");
        }
        return null;

    }
}
