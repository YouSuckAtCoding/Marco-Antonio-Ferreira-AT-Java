package br.infnet.edu.at_java.Classes.Filhas;

import br.infnet.edu.at_java.Classes.Instrumento;
import br.infnet.edu.at_java.Exceptions.InvalidProducaoSomException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "Percussao")
public class Percussao extends Instrumento implements Comparable<Percussao> {

    private boolean CapacidadeAfinacao; 


   
    @Override
    public double CalcularValorParcelado(int parcelas) {
        double valor = ((this.getPreco() * 1.1) / parcelas);       
        return valor;
    }
    
    public void setCapacidadeAfinacao(boolean capacidadeAfinacao) {
		CapacidadeAfinacao = capacidadeAfinacao;
	}

	
    public boolean isCapacidadeAfinacao() {
        return CapacidadeAfinacao;
    }

    @Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" Capacidade Afinação: ");
		sb.append(CapacidadeAfinacao ? "Sim" : "Não");
		sb.append(" Producao de Som: ");
		return sb.toString();
	}
	
    private Exception ValidateData(String producaoSom){
        if(producaoSom.length() <= 0 || producaoSom == null){
            return new InvalidProducaoSomException("O atributo Produção de Som não pode ser vazio.");
        }
        return null;

    }

	@Override
	public int compareTo(Percussao perc) {
		return this.getNome().compareTo(perc.getNome());
		
	}
}
