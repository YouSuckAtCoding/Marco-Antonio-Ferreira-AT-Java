package br.infnet.edu.at_java;

import br.infnet.edu.at_java.Classes.Filhas.Percurssao;

public class PercussaoTests {

    public boolean CreateInstrumentoPercussao(String nome, String tipo, double preco, boolean capacidadeAfinacao, String producaoSom){
        
        try{
            Percurssao teste = new Percurssao(nome, tipo, preco, capacidadeAfinacao, producaoSom);
            if(producaoSom.length() <= 0){
                return false;
            }            
            System.out.println(teste);
            return true;         
        }
        catch(Exception ex){
            System.out.println(ex + " Exceção encontrada em CordaTest.");
            return false;
        }
        
        
    }

    public double TestCalcularParcelasPercussao(int parcelas, double preco){
        try{
            Percurssao teste = new Percurssao("Teste", "Teste", preco, false, "teste");
            return teste.CalcularValorParcelado(parcelas);
        }
        catch(Exception ex){
            System.out.println(ex + " Exceção encontrada em CordaTest.");
            return 0;
        }
        
        
    }

   
}
