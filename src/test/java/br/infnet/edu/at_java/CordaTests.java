package br.infnet.edu.at_java;

import br.infnet.edu.at_java.Classes.Filhas.Corda;

public class CordaTests {

    public boolean CreateInstrumentoCorda(String nome, String tipo, double preco, int numcordas){
        
        try
        {    
            Corda teste = new Corda(nome, tipo, preco, numcordas);
            if(numcordas <= 0){
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

    public double TestCalcularParcelasCordas(int parcelas, double preco){
        try{
            Corda teste = new Corda("Teste", "Teste", preco, 6);
            return teste.CalcularValorParcelado(parcelas);
        }
        catch(Exception ex){
            System.out.println(ex + " Exceção encontrada em CordaTest.");
            return 0;
        }
        
        
    }

    
}


